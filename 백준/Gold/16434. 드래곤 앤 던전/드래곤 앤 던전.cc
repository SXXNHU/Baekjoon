#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Room {
    int type;
    long long atk;
    long long hp;
};
long long N, initial_atk;
vector<Room> rooms;

long long Cal_Min_Hp(){
    long long curr_hp = 0;
    long long need_hp = 0;
    long long curr_atk = initial_atk;

     for(int i=0;i<N;i++){ 
        //몬스터방 설정
        if(rooms[i].type == 1) {
            long long m_atk = rooms[i].atk;
            long long m_hp = rooms[i].hp;
            long long turn = (m_hp + curr_atk - 1) / curr_atk;
            long long damage = (turn-1)*m_atk;
            curr_hp = curr_hp - damage;
            //몬스터의 공격력 30 : 현재hp -30 : 필요hp -(-30)+1
            need_hp = max(need_hp,-curr_hp+1);
        }
        
        // 포션방 설정
        else {
            curr_atk += rooms[i].atk;
            curr_hp += rooms[i].hp;
            if(curr_hp > 0) curr_hp = 0;
        }
    }
    return need_hp;
}


int main() {

    cin >> N >> initial_atk;
    rooms.resize(N);

    for(int i=0;i<N;i++){ 
        cin >> rooms[i].type >> rooms[i].atk >> rooms[i].hp;
    }
    cout << Cal_Min_Hp() << endl;
    return 0;
}