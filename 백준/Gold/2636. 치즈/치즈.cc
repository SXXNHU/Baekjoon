#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;
#define X first
#define Y second

//1인거 찾으면 녹여 -> 0 근데 큐에 안넣어 = 녹인자리로 이동 X

vector<vector<int>> board;
vector<vector<int>> vis1;

int n, m;
int ans=0;
int cnt=0;
int T, i=1;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    board.resize(n, vector<int> (m));
    vis1.resize(n, vector<int> (m));

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >> board[i][j];
            vis1[i][j]=0;
        }
    }


    while(1){
        queue<pair<int, int>> Q;
        Q.push({0,0});
        T++;
        vis1[0][0]=T;
        cnt=0;

    while(!Q.empty()){
        pair<int,int> cur = Q.front();
        Q.pop();
        for(int dir=0;dir<4;dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            // 범위 벗어난 경우 or 방문한 경우 처리
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || vis1[nx][ny]==T) continue;           
            if(board[nx][ny] == 1) {
                //탐색한 치즈 vis처리 안해주면 같은 시간대에 들어가버림
                vis1[nx][ny] = T;
                board[nx][ny] = 0;
                cnt++; continue;
                }
            vis1[nx][ny] = T;
            Q.push({nx,ny});
           }
       }
       if(cnt==0) break;
       else ans=cnt;
    }
    cout << T-1 << '\n' << ans;
}

