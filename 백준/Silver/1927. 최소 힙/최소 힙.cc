#include <iostream>
#include <vector>
#include <queue>
using namespace std;


int n;
typedef long long ll;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	priority_queue<ll, vector<ll>, greater<>> pq;

	for (int i = 0; i < n; i++)
	{
		ll x;
		cin >> x;
		if (x == 0)
		{
			if (!pq.empty())
			{
				cout << pq.top() << '\n';
				pq.pop();
			}
			else
			{
				cout << 0 << '\n';
			}
		}
		else
		{
			pq.push(x);
		}
	}
}