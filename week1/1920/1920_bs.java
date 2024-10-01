import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int a, b;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    a = Integer.parseInt(st.nextToken());
    arr = new int[a];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a; i++) {
      int arrValue = Integer.parseInt(st.nextToken());
      arr[i] = arrValue;
    }
    Arrays.sort(arr);

    b = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < b; i++) {
      int x = Integer.parseInt(st.nextToken());
      int result = binarySearch(x);
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }

  static int binarySearch(int targer) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (high + low) / 2;
      if (targer == arr[mid]) {
        return 1;
      } else if (arr[mid] > targer) {
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return 0;
  }
}


/*
이중반복문으로 작성을 하며 시작을 하였다
이 과정에서 if문에서 조건이 맞으면 break를 걸어 빠져나와 반복문을 종료시키는 방식으로 진행하였다
하지만 시간초과가 떴으며 한참을 생각하다 답안지를 찾아보았다
처음에는 이해가 잘 되지 않아 왜 그런지 한참을 생각해보았다
결론적으로 알고리즘에서 시간복잡도는 항상 최악을 고려해야한다는 부분을 생각에서 제외하고 생각해서 그렇다.
for문으로 작성을 했을 경우 최악의 경우 for문으로 설정된 경우 n번의 동작을 모두 동작 시키는 형식이다.
그러므로 이중 for문의 시간 복잡도는
최선의 경우 : O(n)
최악의 경우 : O(n*m)
이 된다.
그렇다면 정석적인 이진탐색의 경우
최선 : O(n)
최악 : O(n * log N)
이러한 결과로 이중 for문 보다 for문 안에 while문으로 조건을 넣어 반복하는 횟수를 줄이는 것이 좋은 방법이다.

*/