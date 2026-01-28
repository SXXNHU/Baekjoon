import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N][M];
        int min = 256;
        int max = 0; 
        
        for(int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int height = Integer.parseInt(st.nextToken());
                board[i][j] = height;
                if(height > max) max=height;
                if(height < min) min=height;
            }
        }
        
        int answerTime = Integer.MAX_VALUE;
        int answerHeight = -1;
        
        //min부터 max까지 ++하며 탐색 
        for(int target = min; target<=max; target++){
            int removed =0;
            int built =0;
            
            //board 돌면서 target보다 높으면 remove, 낮으면 built
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    int cur = board[i][j];
                    if(cur > target) removed = removed + (cur - target);
                    else if(cur < target) built = built + (target - cur);
                }
            }
            if(B+removed < built) continue;
            
            int time = removed*2 + built;
            if(time < answerTime || (time==answerTime&&target>answerHeight)) {
                answerTime = time;
                answerHeight = target;
            }
        }
        System.out.println(answerTime + " " + answerHeight);
    }
}