import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static int[] averages;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        averages = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\.");
            StringBuilder sb = new StringBuilder();
            sb.append(input[0]).append(input[1]);
            averages[i] = Integer.parseInt(sb.toString());
        }

        for (int cntOfPeople = 1; cntOfPeople <= 1000; cntOfPeople++) {
            if (isPossibleCnt(cntOfPeople, averages)) {
                System.out.println(cntOfPeople);
                break;
            }
        }
    }

    private static boolean isPossibleCnt(int cntOfPeople, int[] averages) {
        for (int avg : averages) {
            int left = 0;
            int right = 10 * cntOfPeople;
            boolean isPossible = false;

            while (left <= right) {
                int sumOfScore = (left + right) / 2;
                int currentAvg = (sumOfScore * 1000) / cntOfPeople;

                if (currentAvg == avg) {
                    if (currentAvg > 10 * 1000) {
                        continue;
                    }
                    isPossible = true;
                    break;
                } else if (currentAvg > avg) {
                    right = sumOfScore - 1;
                } else {
                    left = sumOfScore + 1;
                }
            }

            if (!isPossible) {
                return false;
            }
        }
        return true;
    }
}

