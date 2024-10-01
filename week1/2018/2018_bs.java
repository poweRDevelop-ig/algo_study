import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int startPoint = 1;
        int endPoint = 1;
        int sum = 1;
        int count =1;

        while (endPoint != n) {
            if(sum == n){
                count++;
                endPoint++;
                sum += endPoint;
            }
            else if(sum < n){
                endPoint++;
                sum += endPoint;
            }
            else{
                sum -= startPoint;
                startPoint++;
            }
        }
        System.out.println(count);
    }
}

/*
문제를 풀 때 어려웠던 점
처음에 시간제한이 2초여서 최대 값이 10,000,000이면 시간복잡도로 O(N^2)이 되면 이중 for문을 쓰면 안되겠다고 생각을 하여 다른 방법을 생각해보았지만
생각을 거듭할수록 이중for문으로 구현하는 방법밖에 생각이 나지 않아 결국 답지를 확인하였다.
이중 for문을 사용하여 문제를 푸는 방법이 정답이라고 하여 왜 그렇게 되는지 이해가 되지 않았다.
해답에서는 내부 for문에서 최대값인 10,000,000을 준다 하더라도 최대값인 10,000,000까지 가지 않아서 O(N^2)이 안된다는 결론이였다.
해답을 기준으로 다시 생각해보니 N^2이 되려면 외부와 내부가 전체적으로 반복이 되어야 성립이 되니 n^2 보다 작은 수로 연산이 처리되겠다라고 생각을 하게 되었다.
시간 복잡도에 대해서 단순하게 생각하면 안되고 조금 더 생각을 해야겠다고 느꼈다.

두번째로 코드를 구현 할 때 count값의 초기 값을 1로 줬다. 이것이 결과 값은 같아도 틀렸다고 했다.
결과적으로는 어떠한 값에서 cnt를 1로 줬을 때 값이 부정확해질 수 있다고 하여 cnt를 0으로 설정하고 자기자신도 포함하는 방법이 맞다고 한다.

오답 코드
    int a = Integer.parseInt(br.readLine());
    int cnt =1;

    for(int i = 1; i < a; i++) {
      int b = 0;
      for(int j=i; j<a; j++){
        if (b < a) {
          b+= j;
        }
        else if(b == a) {
          cnt+=1;
          break;
        }
        else{
          break;
        }
      }
    }
    System.out.println(cnt);
  }
 */

