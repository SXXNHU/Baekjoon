#include <iostream>
#include <string>

using namespace std;

int main() {
    string s;
    cin >> s;

    int JOI = 0, IOI = 0;
    for (size_t i = 0; i < s.size() - 2; i++) {
        if (s.substr(i, 3) == "JOI") JOI++;
        if (s.substr(i, 3) == "IOI") IOI++;
    }

    cout << JOI << "\n" << IOI << "\n";
    return 0;
}
