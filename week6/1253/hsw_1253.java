import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 배열을 정렬하여 투 포인터 접근에 유리하게 만듦
        int count = 0;

        for (int k = 0; k < n; k++) {
            int target = arr[k];
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (left == k) { // 자신을 포함하지 않도록 왼쪽 포인터 조정
                    left++;
                    continue;
                }
                if (right == k) { // 자신을 포함하지 않도록 오른쪽 포인터 조정
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if (sum == target) { // 두 수의 합이 target과 같을 때
                    count++;
                    break;
                } else if (sum < target) { // 합이 target보다 작으면 왼쪽 포인터를 증가
                    left++;
                } else { // 합이 target보다 크면 오른쪽 포인터를 감소
                    right--;
                }
            }
        }
        System.out.println(count); // "좋은 수"의 개수 출력
    }
}

