#include<iostream>
#include<algorithm>

using namespace std;

int DP[1005];

int horang(int x, int y){

    	for (int i = 0; i < x-1; i++) {
		for(int j =1 ; j <= y/2 ; j++){
            DP[x-i-1] = DP[x-i] - j;
            for(int k=1; k < x-1 ;k++){
                DP[x-k-1] = DP[x-k+1] - DP[x-k];
                }
            if(DP[1] + DP[2] == DP[3] && DP[1] > 0 && DP[1] < DP[2]){
                    cout << DP[1] << "\n" << DP[2] ;
                    return 0;
            }   
        }
	}
}

int main() {


	int n,tot;
	cin >> n >> tot;

    DP[n] = tot;

    horang(n,tot);
}
