#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, num;
    cin >> n;

    vector<int> count(10001, 0);

    for (int i = 0; i < n; i++) {
        cin >> num;
        count[num]++;
    }

    for (int i = 1; i <= 10000; i++) {
        while (count[i]--) {
            cout << i << '\n';
        }
    }

    return 0;
}
