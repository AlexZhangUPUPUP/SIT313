#include<iostream>
#include<string>
#include <windows.h>
#include<stdio.h>
#include<time.h>
using namespace std;
int sizeofOri; //输入的字符串的长度
string OutPut = " ";
//adhkjahsdjkhakjhdjkhasjdkhajkshdjk 用于测试的字符串
int sizeofOut = 0;

double rateOfCom =0;
struct huffTree {
	int parent;
	int lchild;
	int rchild;
	int weight;
	string flag;
};//哈夫曼树

struct Lowest_Node {
	char ch;
	int ch_num;
};


void coding(int length, huffTree tree[], int n, int &a, int &b) {
	int i;
	int r, s;
	r = s = length;
	for (i = 0; i < n; i++) {
		if ((tree[i].weight < r) && (tree[i].parent == -1)) {
			r = tree[i].weight;
			a = i;
		}
	}
	for (i = 0; i < n; i++) {
		if ((tree[i].weight < s) && (i != a) && (tree[i].parent == -1)) {
			s = tree[i].weight;
			b = i;
		}
	}
}

void frequency(string str) {
	int length = str.length();                    //长度
	Lowest_Node *node = new Lowest_Node[length];  //声明最0节点
	int i, j;            
	for (i = 0; i < length; i++) {
		node[i].ch_num = 0;         //初始化频度
	}
	int char_type_num = 0;          //初始为0种字符
	for (i = 0; i < length; i++) {          //循环整个字符串
		for (j = 0; j < char_type_num; j++) {
			if (str[i] == node[j].ch || (node[j].ch >= 'a'&&node[j].ch <= 'z'&&str[i] + 32 == node[j].ch))
				break;
		}
		if (j < char_type_num) { node[j].ch_num++; }
		else {
			if (str[i] >= 'A'&& str[i] <= 'Z')
				node[j].ch = str[i] + 32;
			else node[j].ch = str[i];
			node[j].ch_num++;
			char_type_num++;
		}
	}

	//按频度从大到小排序
	for (i = 0; i < char_type_num; i++) {
		for (j = i; j < char_type_num; j++) {
			if (node[j].ch_num < node[j + 1].ch_num) {//如果前一个小于后一个，交换
				int temp;                      
				char ch_temp;                   
				temp = node[j].ch_num;
				ch_temp = node[j].ch;
				node[j].ch_num = node[j + 1].ch_num;
				node[j].ch = node[j + 1].ch;
				node[j + 1].ch_num = temp;
				node[j + 1].ch = ch_temp;
			}
		}
	}

	huffTree *huff = new huffTree[2 * char_type_num - 1];
	huffTree temp;
	string *code = new string[2 * char_type_num - 1];
	for (i = 0; i < 2 * char_type_num - 1; i++) {             //节点初始化
		huff[i].parent = -1;
		huff[i].lchild = -1;
		huff[i].rchild = -1;
		huff[i].flag = -1;
	}
	for (j = 0; j < char_type_num; j++) {               
		huff[j].weight = node[j].ch_num;
	}
	int min1, min2;
	for (int k = char_type_num; k < 2 * char_type_num - 1; k++) {       //赋值0级以上的节点
		coding(length, huff, k, min1, min2);
		huff[min1].parent = k;
		huff[min2].parent = k;
		huff[min1].flag = "0";
		huff[min2].flag = "1";
		huff[k].lchild = min1;
		huff[k].rchild = min2;
		huff[k].weight = huff[min1].weight + huff[min2].weight;
	}
	for (i = 0; i < char_type_num; i++) {
		temp = huff[i];
		while (1) {
			code[i] = temp.flag + code[i];
			temp = huff[temp.parent];
			if (temp.parent == -1)break;
		}
	}
	cout << "\n\n字符串的每个字符的huffman编码为：" << endl;
	for (i = 0; i < char_type_num; i++) {
		cout << node[i].ch << " " << code[i] << endl;
	}
	cout << "\n\n字符串的编码为：" << endl;
	for (i = 0; i < length; i++) {
		for (j = 0; j < char_type_num; j++) {
			if (str[i] == node[j].ch) {
			
				cout << code[j] << ""; //输出编码

				int k = code[j].size();//得到编码的长度

				sizeofOut = sizeofOut + k;
		
			
			}
		}
	}

}

int main() {

	int length = 0;               //字符串长度；
	string str;                 //目标字符串；



	cout << "这是哈夫曼编码\n请输入字符串：";
	cin >> str;


	sizeofOri = str.size() * 8; //原来的内存
	unsigned time1 = clock();
	

	frequency(str);              //求各个字符串的频度
	unsigned time2 = clock();

	rateOfCom = ((double) sizeofOut) / ((double)sizeofOri);//压缩比：压缩后的/压缩前的
	cout << "\n原来的内存为：" << sizeofOri << endl;
	cout << "压缩后的内存为：" << sizeofOut << endl;
	cout << "\n\n压缩率为：" << rateOfCom << endl;
	cout << "\n\n运行时间是： " << time2 - time1 << endl;

	getchar();
	getchar();
	return 0;
}