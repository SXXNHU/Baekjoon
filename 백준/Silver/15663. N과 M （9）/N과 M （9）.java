import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> path = new ArrayList<>();

    public static void backtrack(int depth) {
        if (depth == M) { // M개 선택 완료
            for (int num : path) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1; // 이전 값 저장 (중복 방지)
        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[i] != prev) { // 방문하지 않은 숫자 & 중복 방지
                visited[i] = true;
                path.add(arr[i]);
                prev = arr[i]; // 이전 값 업데이트
                backtrack(depth + 1);
                path.remove(path.size() - 1); // 백트래킹 (되돌리기)
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 사전 순 출력을 위해 정렬

        backtrack(0);
    }
}
