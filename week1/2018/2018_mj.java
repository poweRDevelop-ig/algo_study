import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


    public static void main(String[] args) throws IOException {
        //N 입력
        //만약 n=1이면 n+(n+1)+(n+2).. = N 이면 가짓수 1 추가
        //(n+1)+(n+2)... = N이면 가짓수 1 추가

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        //투포인터 사용
        //완전 탐색으로 풀면 O(N^2)가 나오지만
        //투포인터를 사용하면 start포인터와 end포인터를 조정해가면서 구간합을 구하여
        //O(N)의 시간복잡도를 가진다
        //매 루프마다 두 포인터 중 하나는 1씩 증가한다
        //start와 end는 최대 N까지 증가하고, 항상 start<=end다
        //둘이 증가하는 과정은 최대 N번만 반복된다.

        int start=0, end = 0; //start와 end포인터 지정
        int sum=0, count = 0; //배열 내 숫자의 합(sum)과 합이 N을 만족할 경우 가짓수 추가(count)

        while (start <= N) {//start위치가 고정된 상태에서 end의 값을 하나씩 증가시킴
            while (++end <= N) {
                sum += end;//부분합 증가
                if (sum >= N) { //부분합이 N보다 크거나 같을 경우 처리
                    if(sum==N){ //부분합이 N을 만족할 경우
                        count++; //가짓수 추가
                    }
                    break; //아니면 여기서 멈추고 start 포인터를 움직임
                }
            }
            while (++start <= N) { //end포인터 고정된 상태에서 start포인터가 N보다 작을 경우
                sum -= start; //start포인터 값을 추가하면 start포인터 위치가 바뀌므로, 
                                //기존의 start포인터 위치를 제거함
                if (sum <= N) {//
                    if (sum == N) {
                        count++;
                    }
                    break;
                }
            }
        }
        System.out.println(count);


        //투포인터와 슬라이딩 윈도우
        //둘 다 두 개의 포인터를 사용해서 특정 범위 내의 합이나 조건을 처리하는데 유용함
        //투포인터는 두 포인터가 독립적으로 움직이고, 필요에 따라 두 포인터의 위치를 조정함
        //투포인터는 배열이나 리스트의 요소를 비교하거나 특정 조건을 만족하는 쌍을 찾는데 사용됨
        //슬라이딩 윈도우의 경우 윈도우의 크기를 조정함
        //주로 연속적인 부분 배열의 합이나 평균을 구할 때 사용됨
    }
}
