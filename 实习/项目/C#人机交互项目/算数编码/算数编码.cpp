#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include<time.h>

using namespace std;
#define N 40  //输入的字符应该不超过40个

struct L     
{
	char ch; //字符
	int num; //字符出现的次数
	double f;//存储字符的概率 
};



//求概率函数,返回：数组长度；
int proba(string str, char c[], long double p[], int count);
//求概率的辅助函数
int search(vector<L> arch, char, int n);
//编码函数 输出编码结果
long double bma(char c[], long double p[], string str, int number, int size);
//小数转化为2进制
void change(double x);

int main()
{
	string str;                //输入要编码的String类型字符串
	int number = 0, size = 0;  //number--字符串中不重复的字符个数；size--字符串长度
	char c[N];                 //用于存储不重复的字符
	long double p[N], output;   //output--编码结果

	cout << "这里是算数编码\n输入要编码的字符串:";
	getline(cin, str);          //输入要编码的字符串
	unsigned time1 = clock();



	size = str.length();         //字符串长度
	number = proba(str, c, p, size);

	cout.setf(ios::fixed);     
	cout.setf(ios::showpoint);   
	cout.precision(10);

	output = bma(c, p, str, number, size);//调用编码函数，返回编码结果

	cout << "\n\n转化为2进制之后：";
	change(output);
	unsigned time2 = clock();

	cout << "\n\n运行时间是： " << time2 - time1 << endl;

	getchar();
	getchar();
	return 0;
}


//求概率函数
int  proba(string str, char c[], long double p[], int count)
{
	cout.setf(ios::fixed);   
	cout.setf(ios::showpoint);
	cout.precision(3);

	vector<L>pt;                  
	L temp;                  
	temp.ch = str[0];        
	temp.num = 1;
	temp.f = 0.0;
	pt.push_back(temp);      //将该字符及其个数压入向量 
	for (int i = 1; i < count; i++)//对整个字符串进行扫描
	{
		temp.ch = str[i];      
		temp.num = 1;
		temp.f = 0.0;

		for (int j = 0; j < pt.size(); j++)  
		{                                    //若重复，该字符个数加1，并跳出循环
			int k;                           //若不重复，则压入该字符，并跳出循环
			k = search(pt, str[i], pt.size());
			if (k >= 0)
			{
				pt[k].num++;
				break;
			}
			else
			{
				pt.push_back(temp);
				break;
			}
		}

	}
	for (int i = 0; i < pt.size(); i++)             //计算不重复字符出现的概率
	{
		pt[i].f = double(pt[i].num) / count;
	}
	int	number = pt.size();                 
	cout << "各字符概率如下：\n";
	for (int i = 0; i < number; i++)                
	{
		if (count == 0)
		{
			cout << "NO sample!\n";
		}
		else
		{
			c[i] = pt[i].ch;
			p[i] = pt[i].f;
			cout << c[i] << "的概率为：" << p[i] << endl;
		}
	}
	return number;         //返回不重复字符的个数
}

//若搜索发现有重复字符返回正数，默认返回-1
int search(vector<L> arch, char ch1, int n)
{
	for (int i = 0; i < n; i++)
		if (ch1 == arch[i].ch) return i;
	return -1;
}

//编码函数
long double bma(char c[], long double p[], string str, int number, int size)
{
	long double High = 0.0, Low = 0.0, high, low, range;
	//High：下一个编码区间的上限，Low：下一个编码区间的下限；
	//high：下一个编码区间的上限；

	//range：上一个被编码区间长度
	int i, j = 0;
	for (i = 0; i < number; i++)
		if (str[0] == c[i]) break;      //编码第一个字符
	while (j < i)
		Low += p[j++];              //寻找该字符的概率区间下限
	range = p[j];                   //得到该字符的概率长度
	High = Low + range;             //得到该字符概率区间上限

	for (i = 1; i < size; i++)          //开始编码第二个字符
		for (j = 0; j < number; j++)    //寻找该字符在c数组中的位置
		{
			if (str[i] == c[j])
			{
				if (j == 0)         
				{
					low = Low;     
					high = Low + p[j] * range;
					High = high;
					range *= p[j]; 
				}
				else              //若该字符不是在c数组中的第一个字符
				{
					float proba_next = 0.0;
					for (int k = 0; k <= j - 1; k++)
						proba_next += p[k];            
					low = Low + range * proba_next;         //编码区间下限
					high = Low + range * (proba_next + p[j]);//编码区间上限
					Low = low;                         //编码区间下限
					High = high;                       //编码区间上限
					range *= p[j];                     //编码区间长度
				}
			}
			else continue;                           //编码下一个字符
		}
	cout << endl;
	cout << "输入字符串的编码为:" << Low << endl;
	return Low;
}

//将小数转化为2进制
void change(double x)
{
	
	double n = 0;                                       //x为输入小数
	int i = 0;                                          
	int j = 0;
	int a[8];
	for (int i = 0; i < 8; i++)
	{
		a[i] = 0;
	}
	if (x < 0) {
		x = -x;
		j = 1;
	}
	while (i < 8)
	{
		int k;
		n = x * 2;
		k = floor(n);
		a[i] = k;
		x = n - k;
		i = i + 1;

	}
	if (j == 1)
	{
		cout << "-0.";
	}
	else
	{
		cout << "0.";
	}
	for (int k = 0; k < 8;)
	{
		for (int l = 0; l < 4; l++)
		{
			cout << a[k];

			

			k++;
		}
		if (k != 8)
		{
			cout << "";
		}
	}

}

