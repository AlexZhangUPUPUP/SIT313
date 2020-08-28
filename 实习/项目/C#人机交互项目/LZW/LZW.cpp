#include <iostream>
#include<string>
#include<vector>
#include<time.h>

using namespace std;

vector<string> DC;
bool exist(string s)  {

	for (int i = 0; i < DC.size(); i++) {

		if (DC[i] == s)
		{
			
			return true;
		}
	
	}
	return false;
}//判断新的字符是否存在在字典当中

int outCode(string s){

	for (int i = 0; i < DC.size(); i++) {
		if (DC[i] == s){

			cout << "输出字符串的编码是:  " << i <<"  这个字符是："<<" "<< s<< endl;
			return i;
		
		}
	}
	return 0;
}//输出字符串的编码

int main() {

	double Compressionrate;
	string  ss;
	cout << "这里是LZW，请输入要压缩的字符串:  ";
	cin>>ss;
	unsigned time1 = clock();

	int sizeofOriginal = ss.size();
	int sizeofOutput = 0;

	char c = ss[0];
	string sd;
	sd = c; 

	DC.push_back(" "); //0

	DC.push_back("s");//1
	DC.push_back("f");//2
	DC.push_back("d");//3
	DC.push_back("g");//4
  
	

	char p = ss[0];
	string first;
	first = p;

	string kk;
	
	string next;

	for (int i = 0; i < ss.size()-1; i++) {

		char m = ss[i + 1];
		
		next = m;

		string ff = first + next;

		if (exist(ff) == true){
		    
			first = first + next;

		}
		else{

			int size =  outCode(first); //得到输出字符的长短，并输出字符
			if (size >=10)
			{
				size = 2;
			}
			else
			{
				size = 1;
			}
			sizeofOutput = sizeofOutput + size;


			string mm = first + next;
 
			DC.push_back(mm);

			first = next;

			
		}
	}
	outCode(first);
	unsigned time2 = clock();

	cout << "\n\n以下是字典的内容" << endl << endl << endl;
	for (int i = 0; i < DC.size(); i++) {
		
		cout << "编码：" << i << "   字符串：" << DC[i] << endl;
	}


	Compressionrate = ((double)sizeofOutput) / ((double)sizeofOriginal);
	cout << "\n\n原本的大小：" << sizeofOriginal << endl;
	cout << "输出的大小：" << sizeofOutput << endl;
	cout << "压缩率为:  " << Compressionrate << endl;
	cout << "\n运行时间是： " << time2 - time1 << endl;
	getchar();
	getchar();

	return 0;



}