import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node[] tree;

    // 전위 순회
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1]; // 노드 배열 생성

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 띄어쓰기 기준으로 문자열 분리
            char parentValue = st.nextToken().charAt(0); // nextToken() 메서드로 토큰을 하나씩 꺼내오면 StringTokenizer객체에는 해당 토큰이 사라진다
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            // Java에서 char 데이터 타입은 내부적으로 ASCII 코드를 사용
            if (tree[parentValue - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
                tree[parentValue - 'A'] = new Node(parentValue); // 부모 노드를 생성
            }
            if (leftValue != '.') { // 왼쪽 자식이 존재할 경우
                tree[leftValue - 'A'] = new Node(leftValue); // 왼쪽 자식 노드를 생성
                tree[parentValue - 'A'].left = tree[leftValue - 'A']; // 부모 노드와 연결
            }
            if (rightValue != '.') { // 오른쪽 자식이 존재할 경우
                tree[rightValue - 'A'] = new Node(rightValue); // 오른쪽 자식 노드를 생성
                tree[parentValue - 'A'].right = tree[rightValue - 'A']; // 부모 노드와 연결
            }
        }

        // 전위 순회
        preorder(tree[0]);
        System.out.println();

        // 중위 순회
        inorder(tree[0]);
        System.out.println();

        // 후위 순회
        postorder(tree[0]);
        System.out.println();
    }
}
/*
해답 확인 : O
시작은 45번 메인 메서드에서 시작을 한다
각각의 값을 입력해 노드에 집어 넣어 주고 그것이 조건에 맞으면 (. 이 아니면)노드에 넣어준다.
이런식으로 반복을 하여 마지막에 값을 출력 시켜준다.
노드를 만들어서 만드는 방식이 생소하여서 문제를 못 풀었던 것 같다.
 */