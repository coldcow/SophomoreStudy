//#include <stdio.h>
//#include <stdlib.h>
//#include <string.h>
//
//int size = 0;
//int intArray[100];
//
//int main(void)
//{
//
//	return 0;
//}
//
//void insert(int data) {
//	int i;
//	if (!isFull()) {
//		if (size == 0) {
//			intArray[size++] = data;
//			return;
//		}
//		else {
//			for (i = size - 1; i >= 0; i--) {
//				if (intArray[i] > data)
//					intArray[i + 1] = intArray[i];
//				else
//					break;
//			}
//			intArray[i + 1] = data;
//			size++;
//		}
//	}
//}
//
//void insert_(int data) {
//	int i;
//	if (!isFull()) {
//		if (size == 0)
//			intArray[size++] = data;
//		else {
//			for (i = size - 1; i >= 0; i--) {
//				if (intArray[i] > data)
//					intArray[i + 1] = intArray[i];
//				else
//					break;
//			}
//		}
//		intArray[i + 1] = data;
//		size++;
//	}
//}
//
//void insert__(int data) {
//	int i;
//	if (!isFull()) {
//		if (size == 0)
//			intArray[size++] = data;
//		else {
//			for (i = size - 1; i >= 0; i--)
//				if (intArray[i] > data)
//					intArray[i + 1] = intArray[i];
//				else
//					break;
//			intArray[i + 1] = data;
//			size++;
//		}
//	}
//}
//
//int delete() {
//	return intArray[--size];
//}
