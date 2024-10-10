import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] array = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for(int i =0; i<array.length; i++) {
            char c = array[i];
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
            else if ( c=='('){
                stack.push(c);
            }
            else if ( c==')'){
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else {
                sb.append(c);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    static int priority(char c){
        if(c == '(' || c ==')'){
            return 0;
        }
        else if(c =='+' || c == '-'){
            return 1;
        }
        else if (c =='*' || c == '/'){
            return 2;
        }
            return -1;
        }
}
/*
답지 확인 : O
처음 문제를 풀었을 때 이러한 방식이 아니라 if문으로 조건을 걸어주어 다르게 풀어보았다.
결과적으로 예시에서 나오는 정답은 맞았다.
그러나 답안을 제출 했을 때 오답이라고 계속 나왔으며, 다르게 조건을 걸어서 정답을 도출해내도 오답이라고 하였다.
계속 생각을 해서 문제를 수정해도 같은 결과가 나와 결국 답안을 확인 했다.
문제에서 원하는 결과는 어떠한 값에 우선수위를 지정하여 그 값을 비교하여 결과를 내는 방식이였던 것 같다.
예시에서도 괄호가 없는 부분에서도 괄호를 처리해 우선순위를 나누고 있었으며 그 괄호는 '*' , '/' 가 있는 경우였다.
그 후 '+', '-' 를 기준으로 괄호 처리를 하며 진행 되는것인데 이것을 감안하고 답안을 보니 어느정도 이해가 되긴 했다.
결과적으로 각각의 연산자에서 우선순위를 정해 그것을 stack에서 뺴 저장을 할것인지 스택예 계속 쌓을 것인지를 정하는 문제인 것 같다.

결론 : 문제에서 "중위 표기식 같은 경우에는 덧셈과 곱셈의 우선순위에 차이가 있어" 라는 문제를 읽고 이해를 했어야 했는데
단순히 출력의 값만 같으면 될 것이다 라고 생각한 것이 가장 큰 실책이였던 것 같았으며 만약 문제를 제대로 읽었다 하더라도
우선순위를 지정하는 방식을 생각해내지 못했을 것 같다고 생각하였다. 많이 배우고 생각해보게 한 문제가 된 것 같다.

추후 재 도전
 */