import java.io.*;
import java.util.*;

public class Main{
    //노드
    static class node{
        int next, length;
        public node(int next, int length){
            this.next = next;
            this.length = length;
        }
    }
    static ArrayList<ArrayList<node>> tree = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<=N; i++){
            //자리 만들어두고
            tree.add(new ArrayList<>());
        }
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            //양방향 가중치 적용
            tree.get(a).add(new node(b,w));
            tree.get(b).add(new node(a,w));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(BFS(a,b,N)).append('\n');
        }
        System.out.println(sb);
    }
    
    static int BFS(int start, int end, int n){
        Queue<node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(new node(start, 0));
        visited[start]= true;
        while(!q.isEmpty()){
            node cur = q.poll();
            if(cur.next == end) return cur.length;
            for(node next : tree.get(cur.next)){
                if(!visited[next.next]){
                    visited[next.next] = true;
                    q.offer(new node(next.next, cur.length + next.length));
                }
            }
        }
        return -1;
    }
}