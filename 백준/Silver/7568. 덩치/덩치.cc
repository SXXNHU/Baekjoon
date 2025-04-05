#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int x[50], y[50];
    for (int i = 0; i < n; i++)
        cin >> x[i] >> y[i];
    for (int i = 0; i < n; i++) {
        int rank = 1;
        for (int j = 0; j < n; j++) {
            if (x[i] < x[j] && y[i] < y[j])
                rank++;
        }
        cout << rank << ' ';
    }
    return 0;
}
