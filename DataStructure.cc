////include "stack.h"
//#define _CRT_SECURE_NO_WARNINGS
//#include <stdio.h>
//#define MAZE_SIZE 20
//#define WALL '1'
//#define ROAD '0'
//#define GOAL 'x'
//#define VISITED '.'
//#define PATH '#'
//#define MAX_STACK_SIZE 100
//
//int maze_size = 0;
//
//typedef struct {
//	element data[100];
//	int top;
//} StackType;
//
//// StackType tovisit, path;  // �����潺��, �湮�Ѱ�ν���
//
//typedef struct { // ��ü!
//	short r;
//	short c;
//} element;
//// ���α׷� 4.3���� ���� �ڵ� �߰� ��
//
//element here = { 1,0 };
//element entry = { 1, 0 };
//
//char maze[MAZE_SIZE][MAZE_SIZE] = {
//{ '1', '1', '1', '1', '1', '1' },
//{ 'e', '0', '1', '0', '0', '1' },
//{ '1', '0', '0', '0', '1', '1' },
//{ '1', '0', '1', '0', '1', '1' },
//{ '1', '0', '1', '0', '0', 'x' },
//{ '1', '1', '1', '1', '1', '1' },
//};
//
//int is_empty(StackType *s)
//{
//	return (s->top == -1);
//}
//
//void init_stack(StackType* s)
//{
//	s->top = -1;
//}
//
//void push(StackType* s, element item)
//{
//	if (is_full(s)) {
//		//fprintf(stderr, "���� ��ȭ ����\n");
//		return;
//	}
//	else s->data[++(s->top)] = item;
//}
//
//int is_full(StackType* s)
//{
//	return s->top == MAX_STACK_SIZE - 1;
//}
//
//element pop(StackType* s)
//{
//	if (is_empty(s)) {
//		//fprintf(stderr, "���� ���� ����\n");
//		exit(1);
//	}
//	else return s->data[(s->top)--];
//}
//
//// ��ġ�� ���ÿ� ����
//// �̷� ���� ��ǥ�̰� ���̳� �̹� �湮�� ��ΰ� �ƴϸ�
//// �װ��� element�� ���� push
//void push_loc(StackType* s, int r, int c)
//{
//	if (r < 0 || c < 0) return;
//	if (r >= maze_size || c >= maze_size) return;
//	if (maze[r][c] != WALL && maze[r][c] != VISITED && maze[r][c] != PATH) {
//		element tmp;
//		tmp.r = r;
//		tmp.c = c;
//		push(s, tmp);
//	}
//}
//
//// �̷θ� ȭ�鿡 ����Ѵ�. 
//void maze_print(char maze[MAZE_SIZE][MAZE_SIZE])
//{
//	printf("\n");
//	for (int r = 0; r < maze_size; r++) {
//		for (int c = 0; c < MAZE_SIZE; c++) {
//			printf("%c", maze[r][c]);  // ���྿ ���ڿ�ó�� ���
//		}
//	}
//	printf("\n");
//}
//
//// here �ڸ��� �̵��ϰ� �ű⼭ �»������ push_loc�� �Ѵ�
//// here�� PATH�� �ȴ�.
//
//int main(void)
//{
//	int r, c;
//	StackType s;
//
//	init_stack(&s);
//	here = entry;
//	while (maze[here.r][here.c] != 'x') {
//		r = here.r;
//		c = here.c;
//		maze[r][c] = '.';
//		maze_print(maze);
//		push_loc(&s, r - 1, c);
//		push_loc(&s, r + 1, c);
//		push_loc(&s, r, c - 1);
//		push_loc(&s, r, c + 1);
//		if (is_empty(&s)) {
//			printf("����\n");
//			return;
//		}
//		else
//			here = pop(&s);
//	}
//	printf("����\n");
//	return 0;
//}
//
