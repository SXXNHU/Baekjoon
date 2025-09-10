import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람들
        HashSet<String> unheard = new HashSet<>(N * 2);
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine().trim());
        }

        // 보도 못한 사람들 돌면서 교집합 수집
        ArrayList<String> both = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine().trim();
            if (unheard.contains(name)) both.add(name);
        }

        Collections.sort(both);

        StringBuilder sb = new StringBuilder();
        sb.append(both.size()).append('\n');
        for (String s : both) sb.append(s).append('\n');

        System.out.print(sb.toString());
    }
}
