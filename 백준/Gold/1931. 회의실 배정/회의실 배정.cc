#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<pair<int, int>> meetings(n);
    for (int i = 0; i < n; i++) {
        cin >> meetings[i].second >> meetings[i].first;
    }

    sort(meetings.begin(), meetings.end());

    int count = 0;
    int end_time = 0;
    for (int i = 0; i < n; i++) {
        if (meetings[i].second >= end_time) {
            end_time = meetings[i].first;
            count++;
        }
    }

    cout << count << endl;
    return 0;
}
