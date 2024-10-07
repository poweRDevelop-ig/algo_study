import java.util.Scanner;

public class Dj_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄 입력: 카드의 개수 N, 합의 기준 M
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 두 번째 줄 입력: 카드에 쓰여진 숫자들
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt();
        }

        int maxSum = 0;

        // 3장의 카드를 선택하는 모든 경우의 수를 확인
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    // 합이 M을 넘지 않으면서 최대값을 찾는다
                    if (sum <= M && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }

        // 출력: M을 넘지 않으면서 가장 가까운 3장의 합
        System.out.println(maxSum);

        sc.close();
    }
}
