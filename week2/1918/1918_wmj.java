import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*후위연산자 표기법
 * 풀이 방법 : 스택에는 연산자만 사용하고 피연산자는 바로바로 출력하기
 *
 * 1. 알파벳 : 바로 출력한다
 * 2. '('는 그냥 스택에 넣는다
 * 3. ')'는 '('를 만날 때까지 스택에서 빼면서 전부 출력한다.
 *    단, '('는 출력하지 않는다
 * 4. '+', '-', '*', '/'는 스택이 empty가 아니고, '('를 만나지 않을 때까지
 *    자신보다 연산자 우선순위가 높은 것을 전부 빼면서 출력 후, 스택에 넣는다
 *    따라서 '+'나 '-'의 경우 스택이 empty가 되거나, '+'나 '-'를 만날 때까지
 *    '*'와 '/'를 스택에서 빼서 출력 후 현재 보고 있는 Character를 스택에 넣어준다.
 *    '*'나 '/'는 '+','-'를 만날 때까지 빼주면서 출력 후 현재 보고 있는 Cahracter를 스택에 넣는다.
 * 5. 모든 Character를 다 봤다면 스택에 남아 있는 것을 빼면서 출력한다.
 *
 * 차량기지 알고리즘을 이해하면 문제풀이에 도움이 된다고 함
 * 차량기지 알고리즘 : 중위 표기법으로 표현된 수식을 분석할 때 사용하는 알고리즘
 *
 *
 * 후..함수 따로 만드는 거 잘 못하겠따
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine(); //식 입력

        Stack<Character> stack = new Stack<Character>(); //연산자를 넣어둘 스택

        for (int i = 0; i < s.length(); i++) { //식의 길이만큼 반복문 실행
            char c = s.charAt(i); //식 안에 있는 각각의 글자들을 Character로 캐스팅해서 비교
            if ((int) 'A' <= (int) c && (int) 'Z' >= (int) c) { //알파벳을 아스키코드(int)로 캐스팅후 A~Z 범위 안에 있는지 비교
                //만약 알파벳이라면
                sb.append(c); //StringBuilder sb에 넣고 바로 출력
            } else { //알파벳 아니고 연산자의 경우
                //1. 괄호일 경우
                if (c == '(') { //c가 '('라면 바로 스택에 넣는다
                    stack.push(c);
                } else if (c == ')') { //c가 ')'라면 ')'를 만날 때까지 출력
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        //스택이 비어있지 않고, 스택 제일 위에 있는 게 '('가 아니라면
                        sb.append(stack.pop()); //스택에서 뽑아서 sb에 추가
                    }
                    stack.pop();
                } else { //2. 괄호가 아닌 연산자라면
                    while (!stack.isEmpty() && checkPriority(stack.peek()) >= checkPriority(s.charAt(i))) {
                        //스택이 비어있지 않고, 우선순위 함수의 결과 값이 더 클 경우에는
                        //*나 / 연산자일 것이므로, 먼저 출력한다.
                        sb.append(stack.pop());
                    }
                    stack.push(s.charAt(i));
                    //현재 문자를 스택에 추가
                }
            }
        }
        while (!stack.isEmpty()) {//스택에 남아있는 요소 꺼내는 루프
            if (stack.peek() != '(') { //스택의 최상단 요소가 '('가 아닐 경우 스택에서 꺼냄
                sb.append(stack.pop());
            }
        }
        System.out.println(sb); //최종 결과 출력

    }

    private static int checkPriority(char c) { //연산자 우선순위 확인
        if (c == '+' || c == '-') { //숫자가 클 수록 우선순위를 가짐니다
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        return 0;
    }
}
