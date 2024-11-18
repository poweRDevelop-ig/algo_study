import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[] visit;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];        // index 1부터 저장 시키기 위해 +1을 해줌
        visit = new boolean[n+1];       // visit는 index의 값을 따라가야 함

        for(int i = 0; i < m; i++) {        // m개의 갯수를 입력 받아야 하기 때문에 m을 기준으로 반복 시킨다.
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a]= 1;       // 무방향 그래프를 나타냄
        }

        // 방문한 적 없으면 dfs
        for(int i = 1; i <= n; i++) {       // index 1번부터 n까지 반복
            if(!visit[i]) {                 // boolean 의 기본값은 false이니까 if문에 걸린다.   !visit[i]가 true가 아닐 때 조건문에 걸림
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void dfs(int i) {
        visit[i] = true;
        for(int j = 1; j < n+1; j++) {
            if(!visit[j] && arr[i][j]==1) {     // !visit[j]가 false 일 때 조건문에 걸림
                dfs(j);
            }
        }
    }
}
/*
해답 확인 : O
!visit[j]라는 말은 결국 visit[j]가 방문하지 않은 즉, false가 되어야지 조건문에 걸린단 말이다.
이 것으로 했을 때
 */