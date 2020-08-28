
#pragma once
#include <fstream>
#include <vector>
#include<iostream>
#include<string>

using namespace std;

struct Node {
	int weight;
	int num;
	Node* p_left;
	Node* p_right;
	Node* p_parent;
	Node(Node* p_left, Node* p_right, Node* p_parent) : p_left(p_left), p_right(p_right), p_parent(p_parent) {};
};

class BinaryTree
{
public:

	enum Brother { LeftChild, RightChild };
	BinaryTree(int num = 0, int weight = 0);
	~BinaryTree();
	bool swap(Node* p_nodeA, Node* p_nodeB);
	bool addNode(Node* p_parent, Node* p_child, Brother brotherState);
	Node* findNode(Node *p);
	void deleteNode(Node *p_node);
	Node* getRoot() { return p_root; }
	bool setNodeNum(Node* p_node, int num);
	Brother getBrotherState(Node *p_node);
	bool isAncestor(Node* p_nodeChild, Node* p_nodeAncestor);
private:
	Node *p_root;

};


class HuffmanTree
{
public:

	HuffmanTree();
	~HuffmanTree();
	string outputEncode;

	bool encode(string inputStr);
private:
	void weightAdd(Node* p_node);

	static int sum;
	BinaryTree tree;

	
	struct charMap {
		char key;
		std::string value;
		Node* p;
	};
	string getHuffmanCode(Node *p);
	Node * findLarge(Node *);


	vector<charMap> buffers;
	ifstream is;
	ofstream os;
};