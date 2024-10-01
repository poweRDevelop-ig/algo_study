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