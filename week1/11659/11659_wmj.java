import java.io.*;
import java.util.StringTokenizer;

public class 11659_wmj {
    //수 N개 주어짐
    //합을 구하는 횟수 M
    //i번째~ j번째까지 합 구하기

    /*
    * 오답노트
    * 1. 배열의 수를 N+1이 아닌 N으로 함 -> 아직도 이해 안됨..
    * 2. N+1개의 배열 안에서 한꺼번에 누적합을 더하지 않았음 -> 속도 저하의 원인이 됨
    * 3. StringTokenizer를 여러 번 쓰는게 아직 이해가 안됨
    * 4. M번의 반복문 돌리는 과정에서
    *   4-1. a부터 b까지 합을 다시 일일히 구한 것 -> 속도 저하의 원인,
    *       배열 b에서 a-1만큼을 빼면 된다는 것을 배움
    *       a-1까지의 배열을 빼는 이유는, a부터 b까지 더해줘야 하니까..
    * */

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = nums[i-1]+Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(nums[b] - nums[a-1]);

        }

    }
}

