#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
using namespace std;

vector<string> split(const string& in, const string& deli)
{
	vector<string>ret;
	int st = 0, end = in.find(deli);
	while (end != string::npos)
	{
		ret.push_back(in.substr(st, end - st));
		st = end + deli.size();
		end = in.find(deli, st);
	}
	ret.push_back(in.substr(st));
	return ret;
}

int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		string s;
		int n;
		cin >> n;
		cin.ignore();
		unordered_map<string, int> mp;
		for (int i = 0; i < n; i++)
		{
			getline(cin, s);
			vector<string>t = split(s, " ");
			mp[t[1]]++;
		}
		int tot = 1;
		for (auto it = mp.begin(); it != mp.end(); it++)
		{
			tot *= (it->second + 1);
		}
		cout << tot - 1 << '\n';
	}
}
