class Solution {
    boolean[] visited;
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        return answer;
        
    }
    
    void dfs(int k, int[][] dungeons, int count){
        answer = Math.max(count,answer);
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(k < need) continue;
            
            visited[i] = true;
            dfs(k-cost,dungeons, count+1);
            visited[i] = false;
        }
    }
}