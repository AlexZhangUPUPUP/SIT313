
#include "adpthuffman.h"
#include <queue>
#include<stack>
int HuffmanTree::sum = 1;



BinaryTree::BinaryTree(int num, int weight)
{
	p_root = new Node(nullptr, nullptr, nullptr);
	p_root->num = num;
	p_root->weight = weight;
}

BinaryTree::~BinaryTree()
{
	deleteNode(p_root);
}

bool BinaryTree::swap(Node * p_nodeA, Node * p_nodeB)
{
	if (p_nodeA == nullptr || p_nodeB == nullptr || p_nodeA == p_nodeB)
		return false;
	Node *pTemp;
	if (getBrotherState(p_nodeA) == LeftChild) {
		if (getBrotherState(p_nodeB) == LeftChild) {
			pTemp = p_nodeA->p_parent->p_left;
			p_nodeA->p_parent->p_left = p_nodeB->p_parent->p_left;
			p_nodeB->p_parent->p_left = pTemp;
		}
		else {
			pTemp = p_nodeA->p_parent->p_left;
			p_nodeA->p_parent->p_left = p_nodeB->p_parent->p_right;
			p_nodeB->p_parent->p_right = pTemp;
		}
	}
	else {
		if (getBrotherState(p_nodeB) == LeftChild) {
			pTemp = p_nodeA->p_parent->p_right;
			p_nodeA->p_parent->p_right = p_nodeB->p_parent->p_left;
			p_nodeB->p_parent->p_left = pTemp;
		}
		else {
			pTemp = p_nodeA->p_parent->p_right;
			p_nodeA->p_parent->p_right = p_nodeB->p_parent->p_right;
			p_nodeB->p_parent->p_right = pTemp;

		}
	}
	pTemp = p_nodeA->p_parent;
	p_nodeA->p_parent = p_nodeB->p_parent;
	p_nodeB->p_parent = pTemp;
	return true;

}

bool BinaryTree::addNode(Node * p_parent, Node * p_child, Brother brotherState)
{
	if (p_parent == nullptr || p_child == nullptr)
		return false;
	if (brotherState == LeftChild) {
		if (p_parent->p_left != nullptr) {
			std::cout << "error:left child exist!" << std::endl;
			return false;
		}
		p_parent->p_left = p_child;
	}
	else if (brotherState == RightChild) {
		if (p_parent->p_right != nullptr) {
			std::cout << "error:right child exist!" << std::endl;
			return false;
		}
		p_parent->p_right = p_child;
	}
	else {
		std::cout << "error:brotherState is wrong!" << std::endl;
		return false;
	}
	p_child->p_parent = p_parent;
	return true;
}

Node * BinaryTree::findNode(Node *p)
{
	Node *p_node = p_root;
	std::queue<Node *> queue;
	queue.push(p_node);
	while (!queue.empty()) {
		p_node = queue.front();
		if (p_node == p) {
			return p_node;
		}
		queue.pop();
		if (p_node->p_left != nullptr) {
			queue.push(p_node->p_left);
		}
		if (p_node->p_right != nullptr) {
			queue.push(p_node->p_right);
		}
	}
	return nullptr;
}

bool BinaryTree::setNodeNum(Node* p_node, int num)
{
	if (p_node == nullptr)
		return false;
	else {
		p_node->num = num;
		return true;
	}
}

bool BinaryTree::isAncestor(Node * p_nodeChild, Node * p_nodeAncestor)
{
	while (p_nodeChild != p_root) {
		if (p_nodeChild == p_nodeAncestor) {
			return true;
		}
		else {
			p_nodeChild = p_nodeChild->p_parent;
		}
	}
	return false;
}

void BinaryTree::deleteNode(Node *p_node)
{
	if (p_node->p_left != nullptr) {
		deleteNode(p_node->p_left);
	}
	if (p_node->p_right != nullptr) {
		deleteNode(p_node->p_right);
	}
	delete p_node;
}

BinaryTree::Brother BinaryTree::getBrotherState(Node *p_node)
{
	if (p_node->p_parent->p_left == p_node) {
		return LeftChild;
	}
	else {
		return RightChild;
	}
}




HuffmanTree::HuffmanTree() :tree(0, 0)
{
}

HuffmanTree::~HuffmanTree()
{
	os.close();
	is.close();
}



string HuffmanTree::getHuffmanCode(Node *p_n)
{
	std::string huffmanCode = "";
	std::stack<Node *> stack;
	std::deque<char> code;


	while (p_n != tree.getRoot()) {
		if (tree.getBrotherState(p_n) == tree.LeftChild) {
			code.push_back('0');
		}
		else {
			code.push_back('1');
		}
		p_n = p_n->p_parent;
	}

	while (!code.empty()) {
		huffmanCode += code.back();
		code.pop_back();
	}
	return huffmanCode;
}


Node * HuffmanTree::findLarge(Node *p_node)
{
	std::stack<Node *> stack;
	Node *p = tree.getRoot();
	Node *large = p;
	while (p || !stack.empty()) {
		if (p != nullptr) {
			stack.push(p);
			if (p->weight == p_node->weight) {

				if (large->weight != p->weight) {
					large = p;
				}

				else if (large->num > p->num) {
					large = p;
				}
			}
			p = p->p_left;
		}
		else {
			p = stack.top();
			stack.pop();
			p = p->p_right;
		}
	}

	if (large == tree.getRoot()) {
		return p_node;
	}
	return large;
}



bool HuffmanTree::encode(string inputStr)
{

	



	char cbuffer;
	Node *nyt = tree.getRoot();
	for (int i = 0; i < inputStr.length();i++) {
		cbuffer = inputStr[i];
		bool exist = false;
		string code;
		auto existNode = buffers.begin();	
		for (existNode; existNode != buffers.end(); existNode++) {
			if (existNode->key == cbuffer) {
				code = existNode->value;
				
				exist = true;
				cout << cbuffer << "  encode£º " << existNode->value << endl;
				outputEncode += existNode->value;
				break;
			}
		}
		if (exist) {
			Node *root = existNode->p;
			weightAdd(root);
		}
		else {
			
			Node *c = new Node(nullptr, nullptr, nyt);
			c->num = sum++;
			c->weight = 1;

			Node *NYT = new Node(nullptr, nullptr, nyt);
			NYT->num = sum++;
			NYT->weight = 0;

			tree.addNode(nyt, NYT, BinaryTree::LeftChild);
			tree.addNode(nyt, c, BinaryTree::RightChild);
			nyt->weight = 1;

			
			code = getHuffmanCode(nyt);
			if(code=="")
				cout<< cbuffer << "  encode£º " << code << cbuffer << endl;
			else
				cout << cbuffer << "  encode£º " << code << endl;
			outputEncode += code;

			
			charMap* new_cm = new charMap();
			new_cm->key = cbuffer;
			new_cm->p = nyt->p_right;
			new_cm->value = getHuffmanCode(nyt->p_right);
			buffers.push_back(*new_cm);

			
			Node *root = nyt->p_parent;
			weightAdd(root);

			
			nyt = nyt->p_left;
		}

	}
	return false;
}

void HuffmanTree::weightAdd(Node * p_node)
{
	while (p_node != nullptr) {
		Node* large = findLarge(p_node);
		if (large != p_node && !tree.isAncestor(p_node, large)) {
			tree.swap(large, p_node);
			int temp;
			temp = large->num;
			large->num = p_node->num;
			p_node->num = temp;
			for (auto iterator = buffers.begin(); iterator != buffers.end(); iterator++) {
				iterator->value = getHuffmanCode(iterator->p);
			}
		}
		p_node->weight++;
		p_node = p_node->p_parent;
	}
}

int main()
{
	string inputStr;
	HuffmanTree huff;
	cout << "Enter a string:" << endl;
	cin >> inputStr;
	
	huff.encode(inputStr);

	cout << "\nOut put Encode:\n" << huff.outputEncode << endl;
	cout << "Ñ¹ËõÂÊ" << (double)(inputStr.length() * 8) / huff.outputEncode.length() << endl;
	system("pause");
	return 0;
}