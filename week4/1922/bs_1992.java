import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 1; i <= m; i++) {  // 수정: m까지 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, w));
        }

        Collections.sort(list);

        int sum = 0;
        for (Node node : list) {
            int rx = find(node.a);
            int ry = find(node.b);

            if (!isSameParent(rx, ry)) {
                union(rx, ry);
                sum += node.w;
            }
        }
        System.out.println(sum);
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            parents[ry] = rx;
        }
    }

    static boolean isSameParent(int rx, int ry) {
        return rx == parents[ry]; // 간단화
    }
}

class Node implements Comparable<Node> {

    int a;
    int b;
    int w;

    public Node(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}
/*
해설 확인 : O
이전에 풀었던 문제 중 유니온을 사용하는 방식을 이용한다고 한다.
이 방법으로 가중치(w)를 오름차순을 해 가중치가 작은 것을 먼저 비교를 해 노드를 연결 해 나간다.
 */