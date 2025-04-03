#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

// 정렬 기준: 길이 짧은 순 -> 길이 같으면 사전순
bool compare(const string &a, const string &b) {
    if (a.size() != b.size()) return a.size() < b.size();
    return a < b;
}

int main() {
    int n;
    cin >> n;

    set<string> wordSet;  // 중복 제거를 위한 집합
    vector<string> words; // 정렬을 위한 벡터

    for (int i = 0; i < n; i++) {
        string word;
        cin >> word;
        wordSet.insert(word);
    }

    // set의 내용을 vector로 옮기기
    words.assign(wordSet.begin(), wordSet.end());

    // 정렬 수행
    sort(words.begin(), words.end(), compare);

    // 출력
    for (const auto &word : words) {
        cout << word << '\n';
    }

    return 0;
}
