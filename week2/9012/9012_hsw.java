
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stk; 
		for(int i = 0 ; i < N; i++) {
			stk =  new Stack<Character>();
			System.out.println(	check_stk(br.readLine()));
		}
		br.close();
	}
	public static String check_stk(String temp) {
		Stack<Character> stk = new Stack<Character>();
		for(int j = 0; j<temp.length();j++) {
			if(temp.charAt(j) == '(') {
				stk.push('(');
			}else {
				if(stk.isEmpty()) {
					return "NO";
				}else {
					stk.pop();
				}
			}
		}
		if(!stk.isEmpty()) {
			return "NO";
		}else {
			return "YES";
		}
	}
}

