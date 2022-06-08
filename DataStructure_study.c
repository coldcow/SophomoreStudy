#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int element;

typedef struct ListNode { // 노드 타입을 구조체로 정의한다. 
	element data;
	struct ListNode* link;
} ListNode;

typedef struct DlistNode {
	element data;
	struct DlistNode* llink;
	struct DlistNode* rlink;
} DlistNode;

//typedef struct ListNode {
//	int expon;
//	int coef;
//	struct ListNode* link;
//} ListNode;
//
//typedef struct ListType {
//	int size;
//	ListNode* head;
//	ListNode* tail;
//} ListType;

int main(void)
{	

	return 0;
}

//ListNode* insert_first(ListNode* head, element x) {
//	ListNode* p = (ListNode*)malloc(sizeof(ListNode));
//
//	p->data = x;
//	p->link = head;
//	head = p;
//	return head;
//}

ListNode* insert_first(ListNode* head, element x) {
	ListNode* node = (ListNode*)malloc(sizeof(ListNode));
	node->data = x;

	if (head == NULL) {
		head = node;
		node->link = head;
	}
	else {
		node->link = head->link;
		head->link = node;
	}
	return head;
}

ListNode* insert_last(ListNode* head, element x) {
	ListNode* node = (ListNode*)malloc(sizeof(ListNode));
	node->data = x;
	if (head == NULL) {
		head = node;
		node->link = head;
	}
	else {
		node->link = head->link;
		head->link = node;
		head = node;
	}
	return head;
}

ListNode* delete_first(ListNode* head) {
	ListNode* removed;
	if (head == NULL)
		return NULL;
	removed = head;
	head = removed->link;
	free(removed);
	return head;
}

ListNode* delete(ListNode* head, ListNode* pre) {
	ListNode* removed;
	removed = pre->link;
	pre->link = removed->link;
	free(removed);
	return head;
}

ListNode* search_list(ListNode* head, element x) {
	ListNode* p = head;

	while (p != NULL) {
		if (p->data == x)
			return p;
		p = p->link;
	}
	return NULL;
}

ListNode* reverse(ListNode* head) {
	ListNode* p, * q, * r;

	p = head;
	q = NULL;
	
	while (p != NULL) {
		r = q;
		q = p;
		p = p->link;
		q->link = r;
	}
	return q;
}

ListNode* concat_list(ListNode* head1, ListNode* head2) {
	if (head1 == NULL)
		return head2;
	else if (head2 == NULL)
		return head1;
	else {
		ListNode* p = head1;
		while (p->link != NULL)
			p = p->link;
		p->link = head2;
	}
	return head1;
}

//ListType* create() {
//	ListType* plist = (ListType*)malloc(sizeof(ListType));
//	plist->size = 0;
//	plist->head = plist->tail = NULL;
//	return plist;
//}

//void insert_last(ListType* plist, int coef, int expon) {
//	ListNode* temp = (ListNode*)malloc(sizeof(ListNode));
//	if (temp == NULL)
//		exit(1);
//	temp->expon = expon;
//	temp->coef = coef;
//	temp->link = NULL;
//	if (plist->tail == NULL)
//		plist->head = plist->tail = temp;
//	else {
//		plist->tail->link = temp;
//		plist->tail = temp;
//	}
//	plist->size++;
//}

//void poly_add(ListType* plist1, ListType* plist2, ListType *plist3) {
//	ListNode* a = plist1->head;
//	ListNode* b = plist2->head;
//	int sum;
//
//	while (a && b) {
//		if (a->expon == b->expon) {
//			sum = a->coef + b->coef;
//			if (sum != 0)
//				insert_last(plist3, sum, a->expon);
//			a = a->link;
//			b = b->link;
//		}
//		else if (a->expon > b->expon) {
//			insert_last(plist3, a->coef, a->expon);
//			a = a->link;
//		}
//		else {
//			insert_last(plist3, b->coef, b->expon);
//			b = b->link;
//		}
//	}
//
//	for (; a != NULL; a = a->link)
//		insert_last(plist3, a->coef, a->expon);
//	for (; b != NULL; b = b->link)
//		insert_last(plist3, b->coef, b->expon);
//}

ListNode* insert_first(ListNode* head, element data) {
	ListNode* node = (ListNode*)malloc(sizeof(ListNode));
	node->data = data;
	if (head == NULL) {
		head = node;
		node->link = head;
	}
	else {
		node->link = head->link;
		head->link = node;
	}
	return head;
}

void dinsert(DlistNode* before, element data) {
	DlistNode * newnode = (DlistNode*)malloc(sizeof(DlistNode));
	newnode->data = data;
	newnode->rlink = before->rlink;
	newnode->llink = before;
	before->rlink = newnode;
	newnode->rlink->llink = newnode;
}