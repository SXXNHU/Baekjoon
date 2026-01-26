import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] boxUsed = new boolean[9][10];

    static int[] emptyRow = new int[81];
    static int[] emptyCol = new int[81];
    static int emptyBoards = 0; // 빈칸 개수

    static int getBoxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }

    static boolean backtrack(int idx) {
        if (idx == emptyBoards) return true;

        int row = emptyRow[idx];
        int col = emptyCol[idx];
        int box = getBoxIndex(row, col);

        for (int i = 1; i <= 9; i++) {
            if (rowUsed[row][i] || colUsed[col][i] || boxUsed[box][i]) continue;

            board[row][col] = i;
            rowUsed[row][i] = colUsed[col][i] = boxUsed[box][i] = true;

            if (backtrack(idx + 1)) return true;

            rowUsed[row][i] = colUsed[col][i] = boxUsed[box][i] = false;
            board[row][col] = 0;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int row = 0; row < 9; row++) {
            String line = br.readLine().trim();
            for (int col = 0; col < 9; col++) {
                int value = line.charAt(col) - '0';
                board[row][col] = value;

                if (value == 0) {
                    emptyRow[emptyBoards] = row;
                    emptyCol[emptyBoards] = col;
                    emptyBoards++;
                } else {
                    int box = getBoxIndex(row, col);
                    rowUsed[row][value] = true;
                    colUsed[col][value] = true;
                    boxUsed[box][value] = true;
                }
            }
        }

        backtrack(0);

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) sb.append(board[row][col]);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
