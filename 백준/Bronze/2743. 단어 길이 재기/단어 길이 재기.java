import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next(); // 단어 입력 받기
        System.out.println(word.length()); // 길이 출력
        scanner.close();
    }
}
