import java.util.Scanner;

public class Dj_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄 입력: N개의 숫자
        int N = sc.nextInt();
        int[] arr = new int[N + 1];  // 1-based indexing 사용

        // 배열 입력 받기
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        // 누적 합 배열 생성
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 두 번째 줄 입력: M개의 쿼리
        int M = sc.nextInt();

        // 각 쿼리에 대한 결과 계산 및 출력
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            // 구간 합 출력
            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }

        sc.close();
    }
}
