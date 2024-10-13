import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main{
    static int count = 0;
    public static void main(String[] args) throws IOException {

        boolean [] checked = new boolean[100001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        if(N==M){
            System.out.println(0);
            return;
        }
        Queue<Integer> que = new ArrayDeque<>();
        que.add(N);
        checked[N] = true;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0 ; i <size;i++) {
                int now = que.poll();
                if (now == M) {
                    System.out.println(count);
                    return;
                }
                // 이동 가능한 위치들 확인
                int nextPosition1 = now + 1;
                int nextPosition2 = now - 1;
                int nextPosition3 = now * 2;

                // 각 위치가 범위 내에 있고, 아직 방문하지 않은 경우에만 큐에 추가
                if (nextPosition1 <= 100000 && nextPosition1 >= 0 && !checked[nextPosition1]) {
                    que.add(nextPosition1);
                    checked[nextPosition1] = true;  // 큐에 추가할 때 방문 처리
                }
                if (nextPosition2 <= 100000 && nextPosition2 >= 0 && !checked[nextPosition2]) {
                    que.add(nextPosition2);
                    checked[nextPosition2] = true;  // 큐에 추가할 때 방문 처리
                }
                if (nextPosition3 <= 100000 && nextPosition3 >= 0 && !checked[nextPosition3]) {
                    que.add(nextPosition3);
                    checked[nextPosition3] = true;
                }
            }
            count +=1;
        }

    }
}
