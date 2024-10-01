
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int[] arr = new int[a];
    for (int i = 0; i < a; i++) {
      int b = Integer.parseInt(br.readLine());
      arr[i] = b;
    }
    Arrays.sort(arr);
    for (int i = 0; i < a; i++) {
      System.out.println(arr[i]);
    }
  }
}