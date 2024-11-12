import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<11; i++){
            dp[i] = dp[i-1] + dp[i-2]+ dp[i-3];
        }
        for(int i=0; i<n; i++){
            int t = Integer.parseInt(br.readLine());
            System.out.println(dp[t]);
        }
    }
}

/*
해설확인 : O
dp에 들어가 있는 수는 그 수의 1, 2, 3으로 계산을 해 나타낼 수 있는 수이다.
계산식으로 나갔을 때 dp [1]~[3]은 규칙이 없지만, 4번부터는 규칙이 생긴다.
dp[4] -> 7          4 + 2 + 1
dp[5] -> 13         7 + 4 + 2
이런식으로 계산이 되고 있다.
즉 자신의 수보다 낮은 수의 3개의 값의 합이 자신의 값이 되고 있는 규칙이 생기고 있다.
이러한 근거를 바탕으로 코드를 작성하면 된다.

문제가 이해하기 어렵다기 보다는 저런 규칙을 찾아낼 생각을 하지 못하였고 오직 코드상에서 어떻게 풀어나가야 할까 고민을 많이 했던 것 같다.

 */