import java.util.*;

public class Main {
    static int[] parent;
    
    // Union-Find: Find 함수 (경로 압축)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union-Find: Union 함수
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) parent[rootB] = rootA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // 파티 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        int truthCount = sc.nextInt();
        Set<Integer> truthSet = new HashSet<>();

        for (int i = 0; i < truthCount; i++) {
            int person = sc.nextInt();
            truthSet.add(person);
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int partySize = sc.nextInt();
            List<Integer> party = new ArrayList<>();
            int first = sc.nextInt();
            party.add(first);
            for (int j = 1; j < partySize; j++) {
                int person = sc.nextInt();
                party.add(person);
                union(first, person);
            }
            parties.add(party);
        }

        // 모든 진실을 아는 사람을 같은 그룹으로 묶기
        int truthRoot = truthCount > 0 ? find(truthSet.iterator().next()) : -1;
        for (int person : truthSet) {
            union(truthRoot, person);
        }

        // 거짓말할 수 있는 파티 개수 세기
        int count = 0;
        for (List<Integer> party : parties) {
            int root = find(party.get(0));
            if (truthCount == 0 || find(truthRoot) != root) count++;
        }

        System.out.println(count);
    }
}
