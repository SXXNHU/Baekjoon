import java.io.*;
import java.util.*;

public class Main{
    
    static int white;
    static int blue;
    static int[][] arr;
    
    public static void main(String[] args)throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        partition(0,0,N);
        
        System.out.println(white);
        System.out.println(blue);
    }
    
    static void partition(int row, int col, int size){
        
        if(colorSame(row,col,size)){
            if(arr[row][col] == 0) white++;
            else blue++;
            return;
        }
        
        int newSize = size/2;
        
        partition(row,col,newSize); //1사분면 
        partition(row,col+newSize,newSize); //2
        partition(row+newSize,col,newSize); //3
        partition(row+newSize,col+newSize,newSize); //4
    }
    
    static boolean colorSame(int row, int col,int size){
        //파티션 동일 컬러 체크
        int color = arr[row][col];
        
        for(int i=row; i<row+size; i++){
            for(int j=col;j<col+size; j++){
                if(arr[i][j] != color) return false;
            }
        }
        return true;
    }
}