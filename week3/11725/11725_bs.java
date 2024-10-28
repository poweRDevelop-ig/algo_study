import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수

        // 인접 리스트 구성
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // tree 에 값 넣기
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            tree[num1].add(num2);
            tree[num2].add(num1);
        }

        // dfs
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;
        while (!stack.isEmpty()) {
            int cur = stack.pop();

            for (int child : tree[cur]) {
                if (!visited[child]) {
                    stack.push(child);
                    parent[child] = cur;
                    visited[child] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
}
/*
해설 확인 : O
문제를 처음에는 이해를 못했다.
그래서 문제가 어떤걸 의미하는지 물어보았고 어떻게 그려나가야 하는지를 생각하였다.
하지만 트리에 대해서 어떻게 코드를 구현해야하는지 감이 안 잡혀서 해설을 확인하였다.

트리를 활용하여 dfs방식으로 출력을 확인해 나가는 방법이다.
리스트의 배열을 생성하여 그 것으로 자식 노드를 만들어 주는 형식으로 처음 진행한다.
그리고 트리(배열 인덱스)에 값을 넣어 그 부모 자식노드에 대해서 연결을 시켜준다.
            tree[num1].add(num2);
            tree[num2].add(num1);
이 과정은 양방향으로 연결이 되어 있다는 걸 의미하는 코드이다.
그 후 dfs로 각 노드를 탐색하여 출력한다.

 */