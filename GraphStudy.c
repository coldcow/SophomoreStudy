//#include <stdio.h>
//#include <stdlib.h>
//#include <string.h>
//#define MAX_VERTICES 50
//
//int visited[MAX_VERTICES];
//
//typedef struct GraphType {
//	int n;
//	int adj_mat[MAX_VERTICES][MAX_VERTICES];
//} GraphType;
//
//int main(void)
//{
//
//
//	return 0;
//}
//
//void init(GraphType* g) {
//	int r, c;
//	g->n = 0;
//	for (r = 0; r < MAX_VERTICES; r++)
//		for (c = 0; c < MAX_VERTICES; c++)
//			g->adj_mat[r][c] = 0;
//}
//
//void insert_vertex(GraphType* g, int v) {
//	if (((g->n) + 1) > MAX_VERTICES) {
//		fprintf(stderr, "그래프: 정점의 개수 초과");
//		return;
//	}
//	g->n++;
//}
//
//void insert_edge(GraphType* g, int start, int end) {
//	if (start >= g->n || end >= g->n) {
//		fprintf(stderr, "그래프: 정점 번호 오류");
//		return;
//	}
//	g->adj_mat[start][end] = 1;
//	g->adj_mat[end][start] = 1;
//}
//
//// O(n^2)
//void dfs_mat(GraphType* g, int v) {
//	int w;
//	visited[v] = 1;
//	printf("정점 %d ->", v);
//	for (w = 0; w < g -> n; w++) {
//		dfs_mat(g, w);
//	}
//}
//
//// O(n+e)
//void dfs_list(GraphType* g, int v) {
//	GraphNode* w;
//	visited[v] = 1;
//	printf("정점 %d ->", v);
//	for (w = g->list[v]; w; w = w->link)
//		dfs_list(g, w->vertex);
//}
//
//// O(n^2)
//void bfs_mat(GraphType* g, int v) {
//	int w;
//	QueueType q;
//
//	queue_init(&q);
//	visited[v] = 1;
//	printf("%d 방문 ->", v);
//	enqueue(&q, v);
//	whlie (!is_empty(&q)) {
//		v = dequeue(&q);
//		for (w=0; w<g->n; w++)
//			if (g->adj_mat[v][w] && !visited[w]) {
//				visited[w] = 1;
//				printf("%d 방문 ->", w);
//				enqueue(&q, w);
//			}
//	}
//}
//
//// O(n+e)
//void bfs_list(GraphType* g, int v)
//{
//	GraphNode* w;
//	QueueType q;
//	init(&q); // 큐 초기 화
//	visited[v] = 1; // 정점 v 방문 표시
//	printf("%d 방문 -> ", v);
//	enqueue(&q, v); // 시작정점을 큐에 저장
//	while (!is_empty(&q)) {
//		v = dequeue(&q); // 큐에 저장된 정점 선택
//		for (w = g->adj_list[v]; w; w = w->link) //인접 정점 탐색
//			if (!visited[w->vertex]) { // 미방문 정점 탐색
//				visited[w->vertex] = 1; // 방문 표시
//				printf("%d 방문 -> ", w->vextex);
//				enqueue(&q, w->vertex); //정점을 큐에 삽입
//			}
//	}
//}