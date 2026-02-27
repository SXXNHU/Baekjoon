import java.util.*;

class Solution {
    int answer = 0;
    
    static class Node{
        int r,c,dist;
        
        Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            if(cur.r == n-1 && cur.c ==m-1) return cur.dist;
            
            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i]; 
                int nc = cur.c + dc[i];
                
                if(nr < 0 || nr >= n || nc <0 || nc >= m) continue;
                if(visited[nr][nc] == true) continue;
                if(maps[nr][nc] == 0) continue;
                
                q.add(new Node(nr,nc,cur.dist + 1));
                visited[nr][nc] = true;
            }
        }
        return -1;
    }
}