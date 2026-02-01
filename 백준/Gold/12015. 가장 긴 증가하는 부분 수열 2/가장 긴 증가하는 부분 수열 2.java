import java.io.*;
import java.util.*;

public class Main{
    public static int lowerBound(int[] answer, int size, int target){
        int left = 0;
        int right = size-1;
        
        while(left<right){
            int mid = (left+right)/2;
            
            if(answer[mid] >= target){
                right = mid;
            }
            else left = mid+1;
        }
        return left;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] answer = new int[N];
        int answerSize = 1;
        
        answer[0] = arr[0];
        int head = arr[0];
        int tail = arr[answerSize-1];
        
        for(int i=1; i<N; i++){
            if(arr[i] <= head){
                answer[0] = arr[i];
            }
            else if(arr[i] > tail){
                answerSize++;
                answer[answerSize-1] = arr[i];
            }
            else {
                //arr[i]가 들어갈 position 이분탐색
                int position = lowerBound(answer, answerSize, arr[i]);
                answer[position] = arr[i];
            }
            head = answer[0];
            tail = answer[answerSize-1];
        }
        System.out.println(answerSize);
    }
}