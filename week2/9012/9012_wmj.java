import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /*괄호가 쌍이 맞는지 보는 문제*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //몇 개의 데이터를 넣을지

        for (int i = 0; i < T; i++) { //데이터 개수만큼 for문 돌림
            String S = br.readLine(); //괄호 문자열 입력받음
            Stack<Character> ts = new Stack<Character>(); //괄호 쌍 관리할 Stack객체 생성
            for (int j = 0; j < S.length(); j++) { //문자열의 개수만큼 for문돌리기
                if (S.charAt(j) == '(') { //만일 j번째의 문자가 '('라면
                    ts.push(S.charAt(j)); // 스택에 추가
                }else{ //'('가 아닌 ')'일 경우
                    if (ts.empty()) { //스택이 비어있을 때 -> 즉 '('로 시작하지 않을 때
                        ts.push(S.charAt(j)); // ')' 닫는 괄호 추가하고 루프 중단
                        break;
                    }else{ //스택이 비어있지 않을 경우, 스택에서 여는 괄호 제거 -> 쌍을 이룰 때 제거하는 형식임
                        ts.pop();
                    }
                }
            }
             if (ts.empty()) { //루프를 돌리면서 괄호가 쌍을 이룰 때마다 제거한 후 스택이 비어있다면
                 //괄호가 짝이 다 맞다는 뜻이므로 YES를 출력 
                System.out.println("YES");
            } else {
                 //아니면 NO 출력
                System.out.println("NO");
            }

        }
    }
}
