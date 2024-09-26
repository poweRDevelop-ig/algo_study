import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 2798_wmj {
    /*완전탐색
    * 모든 경우의 수를 다 탐색한다고 해서 brute force(폭력) search라고도 한다
    * 완전탐색기법 - brute force 기법, 순열(permutation), 재귀함수, 비트마스크, BFS나 DFS를 활용하는 방법, 백트래킹 등
    * 1. brute force 기법 : N중 for문을 이용해서 푸는 방법
    *   장점 : 모든 경우의 수를 직접 구한 상태에서 돌리기에 쉽고 기초적임
    *   단점 : 시간 방면에서 비효율적
    * 
    * 2. 비트마스크 : 컴퓨터가 사용하는 연산 방식을 사용하여, 정수의 이진수 표현을 자료구조로 쓰는 방법
    *   장점 : 코드가 짧고 수행시간이 빠르다 또한 메모리 사용량이 적다
    *   단점 : C에서 비트연산자들의 우선순위가 비교연산자보다 낮은 부분과, 
    *         오버플로우 문제 등 때문에 실수의 가능성이 굉장히 높다
    *   비트연산자 : AND(&), OR(|), XOR(^), NOT(~), SHIFT(<<, >>)
    *
    * 3. 백트래킹 : 재귀함수를 설계할 때 고려하는 중요한 개념으로,
    *              해를 찾는 도중에 해가 될 것 같지 않은 경로에는 더이상 가지 않고 back함
    * 
    * 4. 재귀함수 : 특정 조건을 만족할 때까지 자기 자신을 지속적으로 호출하는 방법
    *    장점 : 코드가 간결함
    *    단점 : 메모리를 많이 사용하며 속도 면에서 반복문보다 상대적으로 느림
    *
    * 5. 순열 : N개의 원소 중에서 r개를 중복허용 없이 순서대로 늘어 놓는 것
    *   */

/* N장의 카드 받고, M 점수 제시
*  N장 중 3장의 카드의 합이 M을 넘지 않으면서, M과 최대한 가까워야 함
* */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //몇 장의 카드를 받을지
        
        int M = Integer.parseInt(st.nextToken()); //몇 점인지

        int[] card = new int[N]; //N개 짜리 배열 card 선언

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken()); //N개의 숫자 입력
        }

        int result = 0; //결과 담을 result 변수 선언

        for (int i = 0; i < N - 2; i++) { //첫번째 카드 - 연속된 세 장의 카드를 제시해야 하므로,
            //첫 번째 카드는 맨 끝 장까지 올 수 없음 - 두 번째, 세번째가 있어야 하니까..
            //그래서 i는 N-2장까지 반복문을 돌림
            for (int j = i+1; j < N - 1; j++) {
                //두 번째 카드의 경우 첫 번째 카드 다음에 와야 하므로,
                //i+1로 시작하여, N-1까지 반복문
                for (int k = j+1; k < N; k++) { //세 번째 카드도 마찬가지
                    int temp = card[i] + card[j] + card[k]; //세 카드의 값을 합해줌

                    if (temp <= M && temp > result) { //제시한 M보다 작거나 같으면서 ,
                        //다른 반복문으로 탐색한 값보다 클 때 -> M에 최대한 가까울 때
                        result = temp; //result에 temp값을 넣어줌
                    }
                }
            }
        }

        System.out.println(result);//출력



    }
}
