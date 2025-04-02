import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 숫자를 담을 변수
        int num = 0;
        
        // 숫자를 찾았는지 여부를 체크하는 변수
        boolean flag = false;
        
        for(int i=0; i<3; i++) {
            String str = br.readLine();
            
            // 입력받은 문자열의 앞 문자만 따로 빼서 비교
            char c = str.charAt(0);
            
            // 만약 입력받은 문자열이 숫자면 플래그 변경
            if(c != 'F' && c != 'B') {
                num = Integer.parseInt(str);
                flag = true;
            }
            
            // 숫자를 찾은 상태면 다음에 뭐가 오든 + 1 하여 다음 수 추측
            if(flag) {
                num++;
            }
        }
        
        // 조건 분기로 답 출력
        if(num%3==0) {
            if(num%5==0) {
                // FizzBuzz
                System.out.println("FizzBuzz");
            }
            else {
                // Fizz
                System.out.println("Fizz");
            }
        }
        else{
            if(num%5==0) {
                // Buzz
                System.out.println("Buzz");
            }
            else {
                // i
                System.out.println(num);
            }
        }
    }
}
