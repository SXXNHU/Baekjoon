import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int set = 0;

        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            String op = cmd[0];

            if (op.equals("add")) {
                int x = Integer.parseInt(cmd[1]);
                set |= (1 << (x - 1));
            } else if (op.equals("remove")) {
                int x = Integer.parseInt(cmd[1]);
                set &= ~(1 << (x - 1));
            } else if (op.equals("check")) {
                int x = Integer.parseInt(cmd[1]);
                bw.write(((set & (1 << (x - 1))) != 0 ? 1 : 0) + "\n");
            } else if (op.equals("toggle")) {
                int x = Integer.parseInt(cmd[1]);
                set ^= (1 << (x - 1));
            } else if (op.equals("all")) {
                set = (1 << 20) - 1;
            } else if (op.equals("empty")) {
                set = 0;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
