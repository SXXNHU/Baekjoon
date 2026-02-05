import java.io.*;
import java.util.*;

public class Main{
    
    static class City implements Comparable<City>{
        int number;
        int cost;
        
        public City(int number, int cost){
            this.number = number;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(City c){
            return Integer.compare(this.cost, c.cost);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        List<City>[] bus = new List[N+1];
        for(int i=1; i<N+1; i++){
            bus[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            bus[a].add(new City(b,c));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        //노드 간 거리 업데이트 (BFS)
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start,0));
        
        while(!pq.isEmpty()){
            City c = pq.poll();
            if(!visited[c.number]){
                visited[c.number] = true;
                for(City next : bus[c.number]){
                    if(!visited[next.number] && dist[next.number] > c.cost + next.cost){
                        dist[next.number] = c.cost + next.cost;
                        pq.offer(new City(next.number, dist[next.number]));
                    } 
                }
            }
        }
        System.out.println(dist[end]);
    }
}