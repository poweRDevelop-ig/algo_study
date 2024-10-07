import java.util.HashSet;
import java.util.Scanner;

public class Dj_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄에서 N 입력받기
        int N = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();

        // 배열 A에 N개의 정수 입력받아 HashSet에 저장
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }

        // 두 번째 줄에서 M 입력받기
        int M = sc.nextInt();

        // M개의 숫자가 배열 A에 있는지 확인
        for (int i = 0; i < M; i++) {
            int number = sc.nextInt();
            if (set.contains(number)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        sc.close();
    }
}
