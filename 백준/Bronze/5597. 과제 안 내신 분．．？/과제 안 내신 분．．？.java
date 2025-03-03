import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] submitted = new boolean[31]; // 1~30번 학생 표시

        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            submitted[num] = true;
        }

        for (int i = 1; i <= 30; i++) {
            if (!submitted[i]) {
                System.out.println(i);
            }
        }
    }
}
