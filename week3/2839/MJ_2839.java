package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N kg의 설탕을 5kg 봉지와 3kg 봉지를 통해 최대한 적은 봉지 수를 사용하도록 작성

public class Problem_2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 4 || N == 7) { // N이 4이거나 7일 경우에는 3이나 5로 나눌수 없다.
            System.out.println(-1);
        } else if (N % 5 == 0) { // N이 5로 바로 나눠질 경우
            System.out.println(N / 5);
        } else if (N % 5 == 1 || N % 5 == 3) { // N이 6, 8, 11, 13, 16 등일 경우
            System.out.println((N / 5) + 1);
        } else if (N % 5 == 2 || N % 5 == 4) { // N이 9, 12, 14, 17, 19 등일 경우
            System.out.println((N / 5) + 2);
        }
    }
}
