#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define SWAP(x, y, t) ((t)=(x), (x)=(y), (y)=(t))

int main(void)
{
	return 0;
}

// ��������
// �̵� Ƚ��: 3(n - 1)
// ��ü �ð� ���⵵: O(n^2)
// ������ ���� x
void selection_sort(int list[], int n) {
	int i, j, least, temp;
	for (i = 0; i < n - 1; i++) {
		least = i;
		for (j = i + 1; j < n; j++)
			if (list[j] < list[least])
				least = j;
		SWAP(list[i], list[least], temp);
	}
}

// 12 9 5 17 15 63
//		12 12 5 17 15 63
//		9  12 5 17 15 63
// 9 12 5 17 15 63 
//		9 12 12 17 15 63
//		9 9  12 17 15 63
//		5 9  12 17 15 63
// ��������
// �ּ��� ��� O(n), �־��� ��� O(n^2)
// ���� �̵��� �ʿ��ϹǷ� ���ڵ尡 Ŭ ��� �Ҹ��ϴ�.
// ������ ���Ĺ��
// ��κ� ���ĵ� ������ �ſ� ȿ����
void insertion_sort(int list[], int n) {
	int i, j, key;
	for (i = 1; i < n; i++) {
		key = list[i];
		for (j = i - 1; j >= 0 && list[j] > key; j--)
			list[j + 1] = list[j];
		list[j + 1] = key;
	}
}

// ��������
// �� Ƚ��: �ֻ�, ���, �־��� ��� ��� �����ϴ�
// �̵� Ƚ��: O(n^2)
// �̵������� �񱳿��꺸�� �� ���� �ð��� �ҿ�ȴ�
void bubble_sort(int list[], int n) {
	int i, j, temp;
	for (i = n-1; i>0; i--)
		for (j = 0; j<i; j++){
			if (list[j] > list[j + 1])
				SWAP(list[j], list[j + 1], temp);
	}
}

// 12 9 5 17 15 63
// �� ����
// ���� ������ ��� ���� ���ĵ� ����Ʈ���� ����� ���� �Ϳ��� ����
// �ð� ���⵵: �־��� ��� O(n^2), ������� ��� O(n^1.5)
#define MAX_SIZE 100
int sorted[MAX_SIZE];

void merge(int list[], int left, int mid, int right) {
	int i, j, k, l;
	i = left;
	j = mid + 1;
	k = left;

	while (i <= mid && j <= right) {
		if (list[i] <= list[j])
			sorted[k++] = list[i++];
		else
			sorted[k++] = list[j++];
	}
	if (i > mid)
		for (l = j; l <= right; l++)
			sorted[k++] = list[l];
	else
		for (l = i; l <= mid; l++)
			sorted[k++] = list[l];
	for (l = left; l <= right; l++)
		list[l] = sorted[l];
}

// �պ� ����
// log(n)���� �н�, n���� ��
// ���ڵ��� �̵��� �� �н����� 2n�� �߻� -> ��ü ���ڵ��� �̵�: 2nlog(n)��
// ���ڵ��� ũ�Ⱑ ū ��쿡�� �ſ� ū �ð��� ���� �ʷ�
// ����, ���, �־��� ��� ū ���� ���� O(nlog(n))�� ���⵵
// �������̸� �������� �ʱ� �л� ������ ������ �� ����
void merge_(int list[], int left, int mid, int right) {
	int i, j, k, l;
	i = left;
	j = mid + 1;
	k = left;

	while (i <= mid && j <= right) {
		if (list[i] <= list[j])
			sorted[k++] = list[i++];
		else
			sorted[k++] = list[j++];
	}
	if (i > mid)
		for (l = j; l <= right; l++)
			sorted[k++] = list[l];
	else
		for (l = i; l <= mid; l++)
			sorted[k++] = list[l];
	for (l = left; l <= right; l++)
		list[l] = sorted[l];
}

void merge_sort(int list[], int left, int right) {
	int mid;
	if (left < right) {
		mid = (left + right) / 2;
		merge_sort(list, left, mid);
		merge_sort(list, mid + 1, right);
		merge(list, left, mid, right);
	}
}

void partition(int list[], int left, int right) {
	int pivot, temp;
	int low, high;

	low = left;
	high = right + 1;
	pivot = list[left];
	do {
		do
			low++;
		while (low <= right && list[low] < pivot);
		do
			high--;
		while (high >= left && list[high] > pivot);
		if (low < high)
			SWAP(list[low], list[high], temp);
	} while (low < high);

	SWAP(list[left], list[high], temp);
	return high;
}