import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // N과 K 값을 입력받기
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        // 사람들을 담을 리스트 생성 (1부터 N까지 사람 번호 추가)
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }
        
        int idx = 0;  // 첫 번째로 제거할 사람의 인덱스
        System.out.print("<");

        // 리스트에서 사람이 한 명씩 제거될 때까지 반복
        while (!people.isEmpty()) {
            idx = (idx + K - 1) % people.size();  // K번째 사람 찾기 (0-based 인덱스)
            System.out.print(people.remove(idx));  // 해당 사람 제거
            if (!people.isEmpty()) {
                System.out.print(", ");  // 마지막 사람이 아니면 쉼표 출력
            }
        }

        System.out.println(">");  // 마지막 '>' 출력
        
        sc.close();
    }
}