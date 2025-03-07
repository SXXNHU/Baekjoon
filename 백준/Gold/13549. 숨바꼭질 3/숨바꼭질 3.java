import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int MAX = 100000;
    static int[] time = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int start, int target) {
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.fill(time, Integer.MAX_VALUE);
        time[start] = 0;
        deque.add(start);

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == target) {
                return time[now];
            }

            //순간이동(0초)
            if (now * 2 <= MAX && time[now * 2] > time[now]) {
                time[now * 2] = time[now];
                deque.addFirst(now * 2);
            }
            
            //뒤로 이동(1초)
            if (now - 1 >= 0 && time[now - 1] > time[now] + 1) {
                time[now - 1] = time[now] + 1;
                deque.addLast(now - 1);
            }
            
            //앞으로 이동(1초)
            if (now + 1 <= MAX && time[now + 1] > time[now] + 1) {
                time[now + 1] = time[now] + 1;
                deque.addLast(now + 1);
            }
        }

        return -1;
    }
}