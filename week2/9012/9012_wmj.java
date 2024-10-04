import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        /*괄호가 쌍이 맞는지 보는 문제*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); //몇 개의 데이터를 넣을지

        for (int i = 0; i < T; i++) {
            String S = br.readLine();
            Stack<Character> ts = new Stack<Character>();
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == '(') {
                    ts.push(S.charAt(j));
                }else{
                    if (ts.empty()) {
                        ts.push(S.charAt(j));
                        break;
                    }else{
                        ts.pop();
                    }
                }
            }
            if (ts.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
