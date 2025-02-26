import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map, temp;
    static int airCleanerRow = -1;
    static int[] dx = {0, 0, -1, 1}; // 좌, 우, 상, 하
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1 && airCleanerRow == -1) {
                    airCleanerRow = i; // 공기청정기 위쪽 행 저장
                }
            }
        }

        while (T-- > 0) {
            spreadDust();   // 1. 미세먼지 확산
            runAirCleaner(); // 2. 공기청정기 작동
        }

        System.out.println(getTotalDust()); // 최종 미세먼지 양 출력
    }

    // **미세먼지 확산 함수**
    static void spreadDust() {
        temp = new int[R][C]; // 확산된 결과를 저장할 배열

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] > 0) { // 미세먼지가 있는 경우
                    int amount = map[x][y] / 5; // 확산되는 양
                    int spreadCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != -1) {
                            temp[nx][ny] += amount;
                            spreadCount++;
                        }
                    }
                    temp[x][y] += map[x][y] - (amount * spreadCount);
                }
            }
        }

        // 확산 결과를 원래 맵에 반영
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    map[i][j] = temp[i][j];
                }
            }
        }
    }

    // **공기청정기 작동 함수**
    static void runAirCleaner() {
        int top = airCleanerRow;
        int bottom = airCleanerRow + 1;

        // **위쪽 공기청정기: 반시계 방향 순환**
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
        map[top][1] = 0;

        // **아래쪽 공기청정기: 시계 방향 순환**
        for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;
    }

    // **현재 미세먼지 총합 계산 함수**
    static int getTotalDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) sum += map[i][j];
            }
        }
        return sum;
    }
}
