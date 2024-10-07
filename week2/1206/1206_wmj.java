import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1206 {
    public static void main(String[] args) throws IOException {
        /*N개의 문항, 0보다 크거나 같고, 10보다 작거나 같은 정수로 대답할 것
        각 문항의 평균 점수 소수점 셋째 자리에서 자른 값
        각 문항의 평균 점수를 보고 설문조사에 참여한 사람의 수 구하기*/

        /* 첫째 줄 N
        둘째 줄부터 각 문항의 평균 점수
        N은 50보다 작거나 같은 자연수
        평균 점수는 0보다 크거나 같고, 10보다 작거나 같은 소수
        항상 소수점 셋째자리 까지 주어짐
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //몇 개의 문항 받을지
        double[] avg = new double[N]; //문항 별 평균 점수를 N개의 배열에 저장

        for (int i = 0; i < N; i++) {
            avg[i] = Double.parseDouble(br.readLine()); //배열의 i번째에 평균 점수 입력
            avg[i] = avg[i] - Math.floor(avg[i]);
            avg[i] = Math.round(avg[i] * 1000.0) / 1000.0;
        }

        boolean flag;
        double[] cases = new double[1001];
        for (int num = 1; num <= 1000; num++) {
            for (int score = 1; score <= num; score++) {
                cases[score] = Math.floor(((double) score / num) * 1000) / 1000.0;
            }
            flag = true;
            for (int j = 0; j < N; j++) {
                if (Arrays.binarySearch(cases, 0, num + 1, avg[j]) < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(num);
                return;
            }
        }


    }
}
