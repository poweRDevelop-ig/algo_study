//런타임에러??

package week3.q17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Ig17471 {
	
	static int N;
    static int[][] area;
    static int[] population;
    static int min = 99999999;
    static int[] division;  
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        population = new int[N];
        division= new int[N];

        //input process start
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            population[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int num = Integer.parseInt(input[0]);
            for (int j = 1; j <= num; j++) {

                area[i][Integer.parseInt(input[j])-1] = 1;
                area[Integer.parseInt(input[j])-1][i] = 1;
            }
        }
        //input process end

        //main logic start
        dfs(0,0);
        //main logic end

        //result process start
        if(min==99999999){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }
        //result process end
    }


    public static void dfs(int n, int depth){
        if(depth>N/2){ //depth가 N/2일 때 dfs는 return 된다.
            //선거구를 두 개로 나누고 인구수 차를 계산하는 것이기 때문에 N/2에 return 한다.
            //1-3 이 1번 구역, 4-6이 2번 구역일 때와 4-6이 1번 구역, 1-3이 2번 구역일 때의 그 인구수 차는 똑같기 때문이다.
            return;
        }
        int count=0;
        for(int i=0; i<N; i++){
            if(division[i]==0){
                division[i]=2;
                count++;
            } //한 선거구에 모든 지역이 포함되는 경우를 찾는다. count가 N이면 모든 지역이 하나의 선거구에 속하게 된다.
        }

        if(count!=N){
            //division 1 검사
            boolean link1=bfs(division,1);
            //division 2 검사
            boolean link2= bfs(division,2);

            int area1=0; //1번 선거구 인구수
            int area2=0; //2번 선거구 인구수
            if(link1 && link2){ //만약 1번 선거구의 모든 지역이 이어져 있고, 2번 선거구의 모든 지역이 이어져 있다면
                for(int i=0; i<N; i++){
                    if(division[i]==1){
                        area1+= population[i]; //1번 선거구의 인구수를 누적함.
                    }
                    else if(division[i]==2){
                        area2+= population[i]; //2번 선거구의 인구수를 누적함.
                    }
                }
                int area_min = Math.abs(area1-area2); //두 선거구의 인구수 차이를 계산함.
                if(area_min < min){ //지금까지 보인 인구수 차이보다 지금의 인구수 차이가 더 작다면 갱신
                    min = area_min;
                }
            }
        }
        //전체 선거구를 1번, 2번으로 나누는 부분.
        divide_area(depth);
    }

    private static void divide_area(int depth) {
        for(int i=0; i<N; i++){
            if(division[i]==0 || division[i]==2){ //만약 선거구가 아직 나눠지지 않은 경우에
                division[i]=1; //1번 선거구로 지정
                dfs(i, depth +1); //dfs 실행
                division[i]=0; //1번 선거구로 지정한 것을 다시 풀어줌
            }
        }
    }

    private static boolean bfs(int[] division, int n) {
        int[] bfs_visited= new int[N]; //연결된 노드를 방문했는지 하지 않았는지 확인하기 위한 배열
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            if(division[i]==n){ // 지정 선거구인 n번 선거구 중 하나를 queue에 삽입
                queue.add(i);
                bfs_visited[i]=n;
                break;
            }
        }
        while(!queue.isEmpty()){
            int div= queue.poll();
            for(int i=1; i<N; i++){
               if(division[i]==n) { //지정 선거구인 n번 선거구인 경우에만 아래 로직을 실행
                   if (area[div][i] == 1 && bfs_visited[i]==0) { //만약 i번 선거구에 아직 방문하지 않았고, 이전 선거구와 연결되어 있다면
                       queue.add(i); //큐에 i번 지역을 추가
                   }
                   if(area[div][i] == 1){ //이전 선거구와 연결되어 있다면 방문한다.
                       bfs_visited[i] = n;
                   }
               }
            }
        }
        if (check_unconnected(division, n, bfs_visited)) return false;
        return true;
    }

    private static boolean check_unconnected(int[] division, int n, int[] bfs_visited) {
        for(int i=0; i<N; i++){
            if(division[i]== n){ //만약 지정 선거구인 n번 선거구 안에서
                if(division[i]!= bfs_visited[i]){ //연결이 끊어져 있는 지역들이 존재한다면
                    return true;
                }
            }
        }
        return false;
    }
}