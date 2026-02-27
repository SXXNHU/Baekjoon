class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(n, computers, i);
                answer++;
            };
        }
        return answer;
    }
    
    void dfs(int n, int[][] computers, int cur){
        visited[cur] = true;

        for(int j=0; j<n; j++){
            if(computers[cur][j] ==1 && !visited[j]){
                dfs(n, computers, j);
            }
        }
    }
}