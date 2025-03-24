#include <iostream>
#include <unordered_map>

using namespace std;

unordered_map<string, char> map = {
    {"AA", 'A'}, {"AG", 'C'}, {"AC", 'A'}, {"AT", 'G'},
    {"GA", 'C'}, {"GG", 'G'}, {"GC", 'T'}, {"GT", 'A'},
    {"CA", 'A'}, {"CG", 'T'}, {"CC", 'C'}, {"CT", 'G'},
    {"TA", 'G'}, {"TG", 'A'}, {"TC", 'G'}, {"TT", 'T'}
};

int main() {
    int N;
    string dna;
    cin >> N >> dna;

    for (int i = N - 1; i > 0; i--) {
        dna[i - 1] = map[string() + dna[i - 1] + dna[i]];
    }
    
    cout << dna[0] << '\n';
    return 0;
}
