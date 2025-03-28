#include<iostream>

using namespace std;

int n;
int cnt = 0;
bool issued1[40];
bool issued2[40];
bool issued3[40];

void func(int cur)
{
	if (cur == n)
	{
		cnt++;
		return;
	}

	for (int i = 0; i < n; i++) {
		if (issued1[i] || issued2[cur + i] || issued3[cur - i + n - 1])
			continue;
		issued1[i] = 1;
		issued2[cur + i] = 1;
		issued3[cur - i + n - 1] = 1;
		func(cur + 1);
		issued1[i] = 0;
		issued2[cur + i] = 0;
		issued3[cur - i + n - 1] = 0;
	}

}

int main()
{
	cin >> n;
	func(0);
	cout << cnt;
}