import java.io.*;
import java.util.*;

class Solution {
    
    boolean[] visited;
    String[] answer;
    boolean found = false;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (a,b) -> {
            if(!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });
   
        visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN", tickets, path);
        return answer;
    }
    
    void dfs(String cur, String[][] tickets, List<String> path){
        
        if(found) return;
        if(path.size() == tickets.length + 1){
            answer = path.toArray(new String[0]);
            found = true;
            return;
        }
        
        for(int i=0; i<tickets.length;i++){
            if(visited[i]) continue; 
            if(!tickets[i][0].equals(cur)) continue;     
            
            visited[i] = true;
            path.add(tickets[i][1]);
            dfs(tickets[i][1], tickets, path);
            path.remove(path.size()-1);
            visited[i] = false;
        }
        
        
        
    }
}