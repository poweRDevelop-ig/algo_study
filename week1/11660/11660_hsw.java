import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int [][] matrix;
    static int [][] prefixSum;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        matrix = new int[N+1][N+1];
        prefixSum = new int[N+1][N+1];

        // 입력 행렬 저장
        for(int i = 1 ; i <= N ; i++){
            temp = br.readLine().split(" ");
            for(int j = 1; j <= N; j++){
                matrix[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        // Prefix Sum (구간 합) 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefixSum[i][j] = matrix[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }

        // 질의 처리
        for(int i = 0; i < M; i++){
            temp = br.readLine().split(" ");
            int x1 = Integer.parseInt(temp[0]);
            int y1 = Integer.parseInt(temp[1]);
            int x2 = Integer.parseInt(temp[2]);
            int y2 = Integer.parseInt(temp[3]);

            // 구간 합 계산
            int sum = prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
            System.out.println(sum);
        }
    }
}

