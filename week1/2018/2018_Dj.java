import java.util.Arrays;
import java.util.Scanner;

public class Dj_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄에서 N 입력 받기
        int N = sc.nextInt();

        // 두 번째 줄에서 N개의 정수를 입력 받기
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(numbers);

        // 정렬된 숫자를 한 줄씩 출력
        for (int number : numbers) {
            System.out.println(number);
        }

        sc.close();
    }
}
