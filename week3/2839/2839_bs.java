import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int sum =0;
    while(true){
      if(n % 5 ==0){
        sum += n/5;
        System.out.println(sum);
        break;
      }
      else {
        n-=3;
        sum ++;
      }
      if(n < 0){
        System.out.println(-1);
        break;
      }
    }

  }
}
/*
해설 확인 : O
처음에 문제를 풀었을 때 단순히 5를 나누고 그 후 3을 나눴을 때 정답이 나왔었습니다.
그러나 11이라는 수가 최솟값이 나오지 않아 문제가 발생하였습니다.
왜 5를 먼저 나눴냐고 하면 5라는 큰 수를 먼저 사용함으로써 작은 값이 카운트 된다고 단순하게 생각하여 5를 먼저 값을 계산하였는데, 이렇게 하면 11과 같은 수가 나누어지지 않는다.
그래서 다른 조건을 주는것이 좋겠다 했지만 생각을 하지 못하였어서 해설지를 확인하였습니다.
최소한의 봉지를 만드는것이 문제인데 그렇게 하려면 5kg을 최대한 많이 사용하여야 한다.
그렇다면 11과 같은 경우는 5Kg 1개 3kg 3개를 만드는 것이 가장 이상적이다.
이렇게 된다면 5kg을 먼저 나누는 것이 아니라 3kg을 먼저 하나씩 차감시켜 5kg 으로 나누어 떨어지게 만드는 것이 가장 이상적인 방법이라고 한다.
 */