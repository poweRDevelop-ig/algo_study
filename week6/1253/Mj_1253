package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mj_1253 {
    /* 좋은 수 구하기
    *주어진 N개의 수에서 다른 두 수의 합으로 표현되는 수가 있다면
    * 그 수를 '좋은 수'라고 한다.
    * N개의 수 중 좋은 수가 총 몇 개인지 출력하시오
    * 
    *  첫번째 줄 - 수의 개수 N
    * 두번째 줄 - N개의 수의 값
    * */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //N(수의 개수)
        int N = Integer.parseInt(br.readLine()); //숫자 개수 N
        //A(수 데이터 저장 배열)
        int[] A = new int[N];
        //좋은 수의 개수
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        //A배열에 데이터 저장하기
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //A 배열 정렬하기
        Arrays.sort(A);

        //for(k를 0부터 N까지 반복)
        for (int k = 0; k < N; k++) {
            //변수초기화하기(찾고자하는 값 find, 포인터 i, 포인터 j)
            int find = A[k];
            int i = 0;
            int j = N-1;

            while (i < j) {
                if (A[i] + A[j] == find) {
                    if (i != k && j != k) {
                        result++;
                        break;
                    } else if(i==k){
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}
