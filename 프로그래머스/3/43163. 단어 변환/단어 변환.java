import java.io.*;
import java.util.*;

class Solution {
    int answer = 50;
    boolean[] visited;
    
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        boolean exist = false;
        for(String w : words){
            if(w.equals(target)) exist = true;
        }
        if(!exist) return 0;
        
        dfs(begin, target, words, 0); 
        return answer;
    }
    
    void dfs(String cur, String target, String[] words, int depth){
        if(cur.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        if(depth >= answer) return;
        
        for(int i=0; i<words.length;i++){
            if(visited[i]) continue;
            
            if(isOneDiff(cur,words[i])){
                visited[i] = true;
                dfs(words[i], target, words, depth+1);
                visited[i] = false;
            }
        }
    }
    boolean isOneDiff(String a, String b){
        int diff = 0;
        
        for(int i=0; i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return true;
    }
}