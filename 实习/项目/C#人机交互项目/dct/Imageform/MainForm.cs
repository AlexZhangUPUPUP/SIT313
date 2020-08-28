using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Windows.Forms;

namespace Imageform
{
    public partial class MainForm : Form
    {
        // 变量
        private Bitmap originalImage;

        private int blockSize;
        private int threshold;
        private int rate;

        // 用于在处理线程完成后更新UI
        public delegate void UpdateUICallback();

        // 构造函数
        public MainForm()
        {
            InitializeComponent();

            // 指令进入第一个图像框
            pictureBox1.Image = Properties.Resources.placeholder1;

            // 从计数器初始化值
            blockSize = (int)blockCounter.Value;
            threshold = (int)thresholdCounter.Value;
            rate = (int)rateCounter.Value;
            compressButton.Enabled = false;

        }

        // 点击选择按钮，打开对话框选择图像
        private void selectButton_Click(object sender, EventArgs e)
        {
            OpenFileDialog dialog = new OpenFileDialog();
            //dialog.Filter = "JPEG (*.jpeg)|*.jpeg|PNG (*.png)|*.png|
            //                   JPG (*.jpg)|*.jpg|TIFF (*.tif)|*.tif";
            dialog.Filter = "Image files|*.jpeg;*.jpg;*.png;*.tif;*.tiff;*.bmp";
            dialog.InitialDirectory = @"C:\";
            dialog.Title = "Select an image to compress.";

            // 如果图片被选择
            if (dialog.ShowDialog() == DialogResult.OK)
            {
                originalImage = new Bitmap(Image.FromFile(dialog.FileName));
                pictureBox1.Image = originalImage;

                // 更多的指令
                pictureBox2.Image = Properties.Resources.placeholder2;
                compressButton.Enabled = true;
                psnrLabel.Text = "PSNR: undef";
            }
        }

        // 压缩按钮已被单击
        private void compressButton_Click(object sender, EventArgs e)
        {
            // 块大小大于图像尺寸
            if ( blockSize > originalImage.Width || blockSize > originalImage.Height)
            {
                pictureBox2.Image = Properties.Resources.placeholder4;
                return;
            }

            pictureBox2.Image = Properties.Resources.placeholder5;

            // 启动一个用于图像压缩的新线程
            new Thread(new ThreadStart(() => {
                ImageProcessor.compressImage(
                    originalImage,
                    blockSize,
                    threshold,
                    rate);
            })).Start();

            // 禁用按钮，直到图像被处理
            selectButton.Enabled = false;
            compressButton.Enabled = false;
            blockCounter.Enabled = false;
            thresholdCounter.Enabled = false;
            rateCounter.Enabled = false;

            //将事件从dct类链接到这里的处理程序
            ImageProcessor.OnImageProcessed += DCT_OnImageProcessed;
        }

        // 事件处理程序，响应来自dct -class的事件
        void DCT_OnImageProcessed(Bitmap ProcessedImage)
        {
            pictureBox2.Image = ProcessedImage;

            // 调用callbackfunction更新ui元素
            psnrLabel.BeginInvoke(new UpdateUICallback(this.updateUI));
        }

        // 压缩完成后更新ui元素
        private void updateUI()
        {
            // 等待另一个线程设置picturebox2
            Thread.Sleep(100);

            // 计算图像的MSE(平均平方误差)
            Bitmap img1 = originalImage;
            Bitmap img2 = new Bitmap(pictureBox2.Image);

            double mse = 0;
            int width = img1.Width;
            int height = img1.Height;
            

            for (int ii = 0; ii < width; ii++)
            {
                for (int jj = 0; jj < height; jj++)
                {
                    mse += Math.Pow(((img1.GetPixel(ii, jj).R +
                        img1.GetPixel(ii, jj).G +
                        img1.GetPixel(ii, jj).B) / 3) -

                        ((img2.GetPixel(ii, jj).R +
                        img2.GetPixel(ii, jj).G +
                        img2.GetPixel(ii, jj).B) / 3),
                        2);
                }
            }
            mse = mse / (width * height);

            // 计算并设置PSNR
            double psnr = 10 * Math.Log10(Math.Pow(255, 2) / mse);
            psnrLabel.Text = string.Format("PSNR: {0:0.##}", psnr);

            // 再次启用控制
            compressButton.Enabled = true;
            selectButton.Enabled = true;
            blockCounter.Enabled = true;
            thresholdCounter.Enabled = true;
            rateCounter.Enabled = true;
        }

        private void blockCounter_ValueChanged(object sender, EventArgs e)
        {
            int val = (int)blockCounter.Value;

            // 检查当前值是否已经是2的幂
            // (处理程序最终被赋值触发)
            if ((val & (val-1)) == 0)
                return;

            if (val > blockSize){
                blockSize *= 2;
            } else {
                blockSize /= 2;
            }
            
            blockCounter.Value = blockSize;
        }

        private void thresholdCounter_ValueChanged(object sender, EventArgs e)
        {
            threshold = (int)thresholdCounter.Value;
        }

        private void rateCounter_ValueChanged(object sender, EventArgs e)
        {
            rate = (int)rateCounter.Value;
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void MainForm_Load(object sender, EventArgs e)
        {

        }
    }
}
