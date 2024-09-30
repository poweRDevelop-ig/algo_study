import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_10828 {
    public static void main(String[] args) throws IOException {
        /*
        스택
        후입선출구조(LIFO : Last In First Out)
        데이터를 하나씩만 넣고 뺄 수 있다
        깊이 우선 탐색(DFS)에 이용된다
        재귀함수의 동작 흐름과 같은 구조를 가진다.
        */
        
        /*
        * 오답노트
        * else에 뭘 넣어야 할지 몰라서 계속 틀림
        * 경우의 수에 없는 명령일 경우에는 peek으로 처리해야 하는 듯함
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (!stack.empty()) {
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (command.equals("empty")) {
                if (!stack.empty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (command.equals("size")) {
                sb.append(stack.size()).append("\n");
            }else {
                if(!stack.empty()) {
                    sb.append(stack.peek()).append("\n");
                }
                else{
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
