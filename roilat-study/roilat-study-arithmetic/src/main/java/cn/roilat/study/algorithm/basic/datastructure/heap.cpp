#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#define maxn 100010   //这部分可以自己定义堆内存多少个元素
using namespace std;
struct Heap {
	int size, queue[maxn];
	Heap()         //初始化
	{
		size = 0;
		for (int i = 0; i < maxn; i++)
			queue[i] = 0;
	}
	void shift_up(int i)  //上浮
			{
		while (i > 1) {
			if (queue[i] < queue[i >> 1]) {
				int temp = queue[i];
				queue[i] = queue[i >> 1];
				queue[i >> 1] = temp;
			}
			i >>= 1;
		}
	}
	void shift_down(int i)   //下沉
			{
		while ((i << 1) <= size) {
			int next = i << 1;
			if (next < size && queue[next + 1] < queue[next])
				next++;
			if (queue[i] > queue[next]) {
				int temp = queue[i];
				queue[i] = queue[next];
				queue[next] = temp;
				i = next;
			} else
				return;
		}
	}
	void push(int x)   //加入元素
			{
		queue[++size] = x;
		shift_up(size);
	}
	void pop()         //弹出操作
	{
		int temp = queue[1];
		queue[1] = queue[size];
		queue[size] = temp;
		size--;
		shift_down(1);
	}
	int top() {
		return queue[1];
	}
	bool empty() {
		return size;
	}
	void heap_sort()    //另一种堆排方式，由于难以证明其正确性
	{                    //我就没有在博客里介绍了，可以自己测试
		int m = size;
		for (int i = 1; i <= size; i++) {
			int temp = queue[m];
			queue[m] = queue[i];
			queue[i] = temp;
			m--;
			shift_down(i);
		}
	}
};
int main() {
	Heap Q;
	int n, a, i, j, k;
	cin >> n;
	for (i = 1; i <= n; i++) {
		cin >> a;
		Q.push(a); //放入堆内
	}

	for (i = 1; i <= n; i++) {
		cout << Q.top() << " ";  //输出堆顶元素
		Q.pop();        //弹出堆顶元素
	}
	return 0;
}

