import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToNum = new HashMap<>();
        String[] numToName = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName[i] = name;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (isNumeric(query)) {
                int num = Integer.parseInt(query);
                sb.append(numToName[num]).append("\n");
            } else {
                sb.append(nameToNum.get(query)).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
}
