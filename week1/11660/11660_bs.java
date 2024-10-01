import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int[][] arr = new int[a + 1][a + 1];
    int[][] arr2 = new int[a + 1][a + 1];

    for (int i = 1; i <= a; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= a; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] + arr[i][j] - arr2[i - 1][j - 1];
      }
    }
    for (int i = 1; i <= b; i++) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      sb.append(arr2[x2][y2] - arr2[x2][y1 - 1] - arr2[x1 - 1][y2] + arr2[x1 - 1][y1 - 1])
          .append("\n");
    }

    System.out.println(sb);
  }
}