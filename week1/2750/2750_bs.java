
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

/*
문제 풀이
sort 사용 방법
  int a = Integer.parseInt(br.readLine());
  int[] arr = new int[a];
  for (int i = 0; i < a; i++) {
    int b = Integer.parseInt(br.readLine());
    arr[i] = b;
  }
  Arrays.sort(arr);

  for (int j : arr) {
    System.out.println(j);
  }
}
버블소트 사용 방법
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