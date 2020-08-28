using System;
using System.Drawing;

namespace Imageform
{
	public static class ImageProcessor
    {
        #region Public interface
           // 事件处理程序
        public delegate void OnImageProcessedHandler(Bitmap ProcessedImage);
        public static event OnImageProcessedHandler OnImageProcessed;
        // 类的唯一公共接口
        public static void compressImage(Bitmap img, int blockSize, int threshold, int rate)
		{
            // 初始化alpha-array
            double[] alpha = create_alpha (blockSize);
            // 将位图转换为R、G和B，添加填充
            double[,] R; double[,] G; double[,] B;
            convertToArray(img, out R, out G, out B, blockSize);
            // DCT
            R = dct(R, blockSize, alpha);
            G = dct(G, blockSize, alpha);
            B = dct(B, blockSize, alpha);          
            // 压缩
            compress(ref R, blockSize, threshold, rate);
            compress(ref G, blockSize, threshold, rate);
            compress(ref B, blockSize, threshold, rate);
            // IDCT
			R = idct(R, blockSize, alpha);
            G = idct(G, blockSize, alpha);
            B = idct(B, blockSize, alpha);
            //将数组转换为位图，删除填充(我们知道
            //从img.size中知道其初始大小)，并通过事件返回
            //转换后的位图图像
            if (OnImageProcessed != null) OnImageProcessed(convertToImage (R, G, B, img.Size));
		}
        #endregion

        #region DCT & IDCT
        // 离散余弦变换
        private static double[,] dct(double[,] imgArray, int blockSize, double[] alpha)
        {
			int width = imgArray.GetLength(0);
            int height = imgArray.GetLength(1);
            // 构造的系数矩阵
            double[,] C = new double[width, height];
            // 遍历块
            for (int x = 0; x < width; x += blockSize){
                for (int y = 0; y < height; y += blockSize){
                    // 在块中剪切并遍历该块
                    double[,] f = clipArray(imgArray, blockSize, x, y);
                    for (int u = x; u < blockSize + x; ++u){
                        for (int v = y; v < blockSize + y; ++v){
                            // 计算dct内部的和
                            double sum = 0;
                            for (int ii = 0; ii < blockSize; ++ii){
                                for (int jj = 0; jj < blockSize; ++jj){
                                    sum += f[ii, jj] * Math.Cos((2 * ii + 1) * (u - x) * Math.PI / (2 * blockSize)) *
                                                     Math.Cos((2 * jj + 1) * (v - y) * Math.PI / (2 * blockSize));
                                }
                            }
                            C[u, v] = alpha[u - x] * alpha[v - y] * sum;
                        }
                    }
                }
            }
            return C;
        }

        // 逆离散余弦变换
        private static double[,] idct(double[,] dct, int blockSize, double[] alpha)
        {
            int width = dct.GetLength(0);
            int height = dct.GetLength(1);

            double[,] temp = new double[width, height];

            // 遍历块
            for (int x = 0; x < width; x += blockSize){
                for (int y = 0; y < height; y += blockSize){
                    // 剪切块
                    double[,] f = clipArray(dct, blockSize, x, y); // Block itself
                    // 遍历块
                    for (int b_x = x; b_x < x + blockSize; ++b_x){
                        for (int b_y = y; b_y < y + blockSize; ++b_y){
                            // 计算内部的idct和
                            double sum = 0;
                            for (int u = 0; u < blockSize; ++u){
                                for (int v = 0; v < blockSize; ++v){
                                    sum += alpha[u] * alpha[v] * f[u, v] *
                                        Math.Cos(((2d * (double)(b_x - x) + 1d) * (double)u * Math.PI) / (2d * (double)blockSize)) *
                                        Math.Cos(((2d * (double)(b_y - y) + 1d) * (double)v * Math.PI) / (2d * (double)blockSize));
                                }
                            }
                            temp[b_x, b_y] = sum;
                        }
                    }
                }
            }
            return temp;
        }

        #endregion

        #region Compression
        // 压缩图像 
        private static void compress(ref double[,] array, int blockSize, int threshold, int rate)
        {
            // 遍历块
            for (int x = 0; x < array.GetLength(0); x += blockSize){
                for (int y = 0; y < array.GetLength(1); y += blockSize){
                    // 计算一个块的最小值、最大值和步长值
                    double max = 0;
                    double min = 0;
                    double[,] f = clipArray(array, blockSize, x, y);
                    calcMaxMinValues(f, ref max, ref min);
                    double step = (max - min) / Math.Pow(2, rate);
                    // 开始迭代块
                    for (int ii = x; ii < x + blockSize; ++ii){
                        for (int jj = y; jj < y + blockSize; ++jj){
                            // 检查绝对值是否小于给定阈值
                            if (Math.Abs(array[ii, jj]) < threshold){
                                array[ii, jj] = 0;
                            }         
                            // 根据计算的步骤对数值进行量化
                            else
                            {
                                double temp = max;
                                while (temp > Math.Abs(array[ii, jj])) temp -= step;
                                array[ii, jj] = Math.Sign(array[ii, jj]) * temp;
                            }
                        }
                    }
                }
            }
        }

        // 计算给定矩阵的绝对最小值和最大值
        private static void calcMaxMinValues(double[,] array, ref double max, ref double min)
        {
            for (int ii = 0; ii < array.GetLength(0); ++ii)
            {
                for (int jj = 0; jj < array.GetLength(1); ++jj)
                {
                    if (Math.Abs(array[ii, jj]) > max) max = Math.Abs(array[ii, jj]);
                    if (Math.Abs(array[ii, jj]) < min) min = Math.Abs(array[ii, jj]);
                }
            }
        }

        #endregion

        #region Helper-functions

        //从给定的图像数组中剪切一个size*size子数组
        private static double[,] clipArray(double[,] array, int size, int x, int y)
		{
			double[,] temp = new double[size, size];
			for (int ii = 0; ii < size; ++ii)
			{
				for (int jj = 0; jj < size; ++jj)
				{
					temp [ii, jj] = array [ii + x, jj + y];
				}
			}
			return temp;
		}

        // 创建在DCT和IDCT中使用的字母数组
        private static double[] create_alpha(int blockSize)
        {
            double[] alpha = new double[blockSize];
            for (int ii = 0; ii < blockSize; ++ii)
            {
                alpha[ii] = Math.Sqrt(2d / blockSize);
            }
            alpha[0] = 1d / Math.Sqrt((double)blockSize);
            return alpha;
        }

        #endregion

        #region Conversions

        // 将位图图像转换为多维数组
        private static void convertToArray(Bitmap img, out double[,] R, out double[,] G, out double[,] B, int blockSize)
        {
            // 默认图像大小
            int width = img.Width;
            int height = img.Height;
            // 计算可能的填充
            int blockrows = (int)Math.Floor((double)img.Width / (double)blockSize);
            int blockcols = (int)Math.Floor((double)img.Height / (double)blockSize);
            if (blockrows*blockSize != img.Width) { width = (blockrows + 1) * blockSize; }
            if (blockcols*blockSize != img.Height) { height = (blockcols + 1) * blockSize; }
            R = new double[width, height];
            G = new double[width, height];
            B = new double[width, height];
            // 迭代图像，获取像素数据
            for (int x = 0; x < width; ++x){
                for (int y = 0; y < height; ++y){
                    // 检查是否需要pad
                    if (x >= img.Width || y >= img.Height)
                    {
                        R[x, y] = 0; G[x, y] = 0; B[x, y] = 0;
                        continue;
                    }
                    // 如果没有，就获取像素值
                    R[x, y] = img.GetPixel(x, y).R;
                    G[x, y] = img.GetPixel(x, y).G;
                    B[x, y] = img.GetPixel(x, y).B;
                }
            }
        }

        //将多维数组转换为位图图像
        private static Bitmap convertToImage(double[,] R, double[,] G, double[,] B, Size imsize)
        {
            // 原始图像大小
            int width = imsize.Width;
            int height = imsize.Height;
            Bitmap temp = new Bitmap(width, height);
            // 迭代图像数组
            for (int ii = 0; ii < width; ++ii){
                for (int jj = 0; jj < height; ++jj){
                    // 确保值在0-255范围内，因为是量子化算法
                    int r = Math.Max(0, Math.Min(255, (int)R[ii, jj]));
                    int g = Math.Max(0, Math.Min(255, (int)G[ii, jj]));
                    int b = Math.Max(0, Math.Min(255, (int)B[ii, jj]));
                    temp.SetPixel(ii, jj, Color.FromArgb(r, g, b));
                }
            }
            return temp;
        }
		#endregion
    }
}
