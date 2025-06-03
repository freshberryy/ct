#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n;
typedef long long ll;

struct cmp
{
	bool operator()(ll a, ll b)
	{
		if (abs(a) == abs(b)) return a > b;
		return abs(a) > abs(b);
	}
};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	priority_queue<ll, vector<ll>, cmp> pq;

	for (int i = 0; i < n; i++)
	{
		int x;
		cin >> x;
		if (x == 0)
		{
			if (pq.empty()) cout << 0 << '\n';
			else
			{
				cout << pq.top() << '\n';
				pq.pop();
			}
		}
		else
		{
			pq.push(x);
		}
	}
}