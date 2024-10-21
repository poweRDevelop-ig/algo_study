import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] time = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      time[i][0] = Integer.parseInt(st.nextToken());
      time[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(time, (a, b) -> {
      if (a[1] == b[1]) {
        return a[0] - b[0];
      } else {
        return a[1] - b[1];
      }
    });

    int result = 0;
    int endTime = 0;

    for (int[] t : time) {
      if (t[0] >= endTime) {
        endTime = t[1];
        result++;
      }
    }

    System.out.println(result);

  }
}

/*
해설 확인 : O
문제를 잘못 이해하고 시작을 하였음
최대한 많은 회의를 할 수 있게 해야하는데 이걸 이해하지 못하고 순차적으로 진행이 되어야 한다고 생각을 하였다.
그래서 결과는 안되었으며 문제를 이해하고 난 후에도 어떻게 처리를 해야하는 코드가 생각이 안나서 해설을 봤다.

결과적으로 아래 반복문처럼 진행하는 방식은 이전에 혼자 풀었던 방식과 비슷하였지만 빠트린 부분은 오름차순 정렬 (sort)가 없었다.
처음은 끝나는 시간을 오름차순으로 한다. 오름차순으로 했을 때 같은 시간은 시작시간에 따라 정렬을 맞춰준다.
시작 시간에서 오름차순을 쓰는 이유는 먼저 시작하는 회의를 진행시켜야 하기 때문이다.
결과적으로 위 코드는 람다식을 사용하여 Comparator를 처리하는 코드이다.
<람다식을 안 쓴 방법>
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0]; // 종료 시간이 같으면 시작 시간 기준 정렬
                } else {
                    return a[1] - b[1]; // 종료 시간 기준 정렬
                }
            }
        });
 */