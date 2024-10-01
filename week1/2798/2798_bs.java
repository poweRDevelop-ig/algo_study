import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int[] arr = new int[a];
    int result = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < arr.length-2; i++) {
      for(int j = i+1; j < arr.length-1; j++) {
        for(int k = j+1; k < arr.length; k++) {
          if(arr[i] + arr[j] + arr[k] <= b && arr[i] + arr[j] + arr[k] > result ) {
            result = arr[i] + arr[j] + arr[k];
          }
        }
      }
    }
    System.out.println(result);
  }
}

/*
처음 문제를 봤을 때 가장 간단한 방법으로는 전체탐색(브루트 포스)을 이용하면 되겠다 싶었다.
즉, 전체적으로 반복문을 돌리면 가장 간단한 코드로 완성이 될 것 같았다.
그리고 시간 복잡도를 확인 해 본 결과로 n의 값이 최댁 100인 것을 보았고 이것은 for문에서 최대 100번이 돈다는 의미였다.
총 3개의 카드를 이용한다고 하였으니 결과적으로 반복문은 3개가 필요하며
이것은 시작복잡도로 O(n^3)가 된다.
100^3 은 1,000,000 이므로 전체적으로 반복문을 돌려도 되겠다 생각하여 문제를 풀게 되었다.
결과는 100ms라는 시간이 나왔다.

 */