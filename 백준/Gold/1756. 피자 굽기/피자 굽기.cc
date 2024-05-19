#include <iostream>
#include <vector>
using namespace std;

int D,N;
vector<int>depth;
vector<int>pizza;
int main() {
    cin>>D>>N;
    depth.resize(D+1);
    pizza.resize(N);
    depth[0]=1000000001;
    for(int i=1; i<=D; i++) {
        cin>>depth[i];
        if(depth[i-1]<depth[i]) depth[i]=depth[i-1];
    }
    for(int i=0; i<N; i++) {
        cin>>pizza[i];
    }
    int start=D;
    for(int i=0; i<N; i++) {
        for(int j=start; j>=0; j--) {
            if(j==0) {
                cout<<0;
                return 0;
            } 
            if(depth[j]>=pizza[i]) {
                start=j-1;
                break;
            }
        }
    }
    cout<<start+1;
}