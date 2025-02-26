import java.util.*;

public class Main {
    static int N, M, r, c, d;
    static int[][] map;
    static boolean[][] cleaned;
    
    // 방향: 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0}; 
    static int[] dy = {0, 1, 0, -1}; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        
        map = new int[N][M];
        cleaned = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(cleanRoom());
    }

    static int cleanRoom() {
        int count = 0;

        while (true) {
            // 1. 현재 위치 청소
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                count++;
            }

            boolean moved = false;

            // 2. 왼쪽 방향부터 탐색 (반시계 회전)
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 90도 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                // 청소되지 않은 빈 칸이 있으면 전진 후 다시 탐색
                if (map[nx][ny] == 0 && !cleaned[nx][ny]) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            // 네 방향 모두 청소된 경우
            if (!moved) {
                int backX = r - dx[d];
                int backY = c - dy[d];

                // 후진 가능하면 후진
                if (map[backX][backY] == 0) {
                    r = backX;
                    c = backY;
                } else { // 후진 불가능하면 종료
                    break;
                }
            }
        }

        return count;
    }
}
