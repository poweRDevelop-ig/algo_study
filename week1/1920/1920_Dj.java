import java.util.Scanner;

public class Dj_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: 배열 크기(N)와 쿼리 수(M)
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 배열 입력 받기
        int[][] arr = new int[N + 1][N + 1];  // 1-based 인덱스 사용
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 누적 합 배열을 생성
        int[][] prefixSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 누적 합 계산
                prefixSum[i][j] = arr[i][j]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        // 각 쿼리에 대해 구간 합을 계산 및 출력
        for (int q = 0; q < M; q++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            // 구간 합 계산: (x1, y1)부터 (x2, y2)까지
            int result = prefixSum[x2][y2]
                    - prefixSum[x2][y1 - 1]
                    - prefixSum[x1 - 1][y2]
                    + prefixSum[x1 - 1][y1 - 1];

            // 결과 출력
            System.out.println(result);
        }

        sc.close();
    }
}