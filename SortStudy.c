#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define SWAP(x, y, t) ((t)=(x), (x)=(y), (y)=(t))

int main(void)
{
	return 0;
}

// 선택정렬
// 이동 횟수: 3(n - 1)
// 전체 시간 복잡도: O(n^2)
// 안정성 만족 x
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
// 삽입정렬
// 최선의 경우 O(n), 최악의 경우 O(n^2)
// 많은 이동이 필요하므로 레코드가 클 경우 불리하다.
// 안정된 정렬방법
// 대부분 정렬돼 있으면 매우 효율적
void insertion_sort(int list[], int n) {
	int i, j, key;
	for (i = 1; i < n; i++) {
		key = list[i];
		for (j = i - 1; j >= 0 && list[j] > key; j--)
			list[j + 1] = list[j];
		list[j + 1] = key;
	}
}

// 버블정렬
// 비교 횟수: 최상, 평균, 최악의 경우 모두 일정하다
// 이동 횟수: O(n^2)
// 이동연산이 비교연산보다 더 많은 시간이 소요된다
void bubble_sort(int list[], int n) {
	int i, j, temp;
	for (i = n-1; i>0; i--)
		for (j = 0; j<i; j++){
			if (list[j] > list[j + 1])
				SWAP(list[j], list[j + 1], temp);
	}
}

// 12 9 5 17 15 63
// 셸 정렬
// 삽입 정렬이 어느 정도 정렬된 리스트에서 대단히 빠른 것에서 착안
// 시간 복잡도: 최악의 경우 O(n^2), 평균적인 경우 O(n^1.5)
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

// 합병 정렬
// log(n)개의 패스, n번의 비교
// 레코드의 이동이 각 패스에서 2n번 발생 -> 전체 레코드의 이동: 2nlog(n)번
// 레코드의 크기가 큰 경우에는 매우 큰 시간적 낭비 초래
// 최적, 평균, 최악의 경우 큰 차이 없이 O(nlog(n))의 복잡도
// 안정적이며 데이터의 초기 분산 순서에 영향을 덜 받음
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