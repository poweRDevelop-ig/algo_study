import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            parents[n] = n;
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (k == 0) {
                union(a, b);
            } else {
                sb.append(findParent(a) == findParent(b) ? "YES" : "NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    static int findParent(int x) {
        if (x == parents[x]) return x;
        return parents[x] = findParent(parents[x]);
    }

    static void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if (px != py) parents[py] = px;
    }
}
/*
해답 확인 : O
문제는 맨 처음 1이라고 나온 수의 집합이 같으면 YES 아니면 NO를 내보내는 문제이다.
k a b를 입력했을 떄 k 가 0 이면 union이라는 함수로 가 a 와 b의 부모를 찾아 같지 않으면 서로의 노드를 양방향으로 연결시킨다.
k가 1이면 a와 b를 넣었을 때 자신의 부모가 x이면 x를 반환 그렇지 않으면 재귀적으로 찾아가 부모를 직접 저장한다. 이 방식을 경로 압축이다.
경로 압축을 하는 이유는 부모 노드를 빠르게 찾을 수 있게 하기 위함이다.
이 후 같은 집합에 속하면 YES  아니면 NO를 출력한다.

 */