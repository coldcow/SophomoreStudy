//#include <stdio.h>
//#include <stdlib.h>
//#include <string.h>
//#define MAX_VERTICES 50;
//
//typedef struct TreeNode {
//	int data;
//	struct TreeNode* left, * right;
//} TreeNode;
//
//int main(void)
//{
//
//
//	return 0;
//}
//
//void preorder(TreeNode* root) {
//	if (root) {
//		printf("%d", root->data);
//		preorder(root->left);
//		preorder(root->right);
//	}
//}
//
//void inorder(TreeNode* root) {
//	if (root) {
//		inorder(root->left);
//		printf("%d", root->data);
//		inorder(root->right);
//	}
//}
//
//void postorder(TreeNode* root) {
//	if (root) {
//		postorder(root->left);
//		postorder(root->right);
//		printf("%d", root->data);
//	}
//}
//
//// 이진탐색트리 순환적 방식
//TreeNode* search_cycle(TreeNode* node, int key)
//{
//	if (node == NULL)
//		return NULL;
//	if (key == node->data)
//		return node;
//	else if (key < node->data)
//		return search(node->left, key);
//	else
//		return search(node->right, key);
//}
//
//// 이진탐색트리 반복적 방식
//TreeNode* search_repeat(TreeNode* node, int key) {
//	while (node != NULL) {
//		if (key == node->data)
//			return node;
//		else if (key < node->data)
//			node = node->left;
//		else
//			node = node->right;
//	}
//	return NULL;
//}
//
//TreeNode* new_node(int key) {
//	TreeNode* temp = (TreeNode*)malloc(sizeof(TreeNode));
//	temp->data = key;
//	temp->left = NULL;
//	temp->right = NULL;
//
//	return temp;
//}
//
//TreeNode* insert_node(TreeNode* node, int key) {
//	if (node == NULL)
//		return new_node(key);
//
//	if (key < node->data)
//		node->left = insert_node(node->left, key);
//	else if (key > node->data)
//		node->right = insert_node(node->right, key);
//
//	return node;	
//}
//
//TreeNode* delete_node(TreeNode* root, int key) {
//	if (root == NULL)
//		return root;
//
//	if (key < root->data)
//		root->left = delete_node(root->left, key);
//	else if (key > root->data)
//		root->right = delete_node(root->right, key);
//	else {
//		if (root->left == NULL) {
//			TreeNode* temp = root->right;
//			free(root);
//			return temp;
//		}
//		if (root->right == NULL) {
//			TreeNode* temp = root->left;
//			free(root);
//			return temp;
//		}
//
//		TreeNode* temp = min_value_node(root->right);
//		root->data = temp->data;
//		root->right = delete_node(root->right, temp->data);
//	}
//	return root;
//}
//
//TreeNode* min_value_node(TreeNode* node) {
//	TreeNode* current = node;
//	while (current->left != NULL)
//		current = current->left;
//
//	return current;
//}