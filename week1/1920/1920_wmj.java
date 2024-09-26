import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*이중 for문으로 돌렸더니 NullPointerException이 떴음
*
* 이진탐색
* 여러 개의 수가 정렬된 순서로 있을 때 특정한 수를 찾는 방법
* 중간값을 선택해 찾으려는 값이 더 크면 오른쪽, 작으면 왼쪽으로 범위를 좁혀가며 탐색
* 매번 비교되는 요소의 수가 절반으로 감소
* 시간복잡도 : O(logN)
*
* 검색의 전제 조건
* 데이터가 정렬된 상태여야 함 - 타겟 데이터를 찾지 못하면 cross(교차) 발생
* cross 발생 시 반복문 종료
* */


public class 1920_wmj {
    public static int[] A; //배열 만들 때도 쓰고, 이진탐색할 때도 써야 하므로 전역변수로 선언
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //몇 개의 정수를 입력할지
        A = new int[N]; //N개짜리 배열 A만듦

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) { //배열 A에 숫자 입력해서 넣음
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); //이진탐색은 데이터가 정렬된 상태여야 하므로 정렬해줌
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());//몇 개의 정수를 입력할지

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            if (binarySearch(Integer.parseInt(st.nextToken())) >= 0) { 
                //리턴되는 값이 -1이 아닌 양수라면 1을 출력
                sb.append(1).append("\n");
            } else {
                //-1이 리턴되면 0을 출력
                sb.append(0).append("\n");
            }
        }
    }

    public static int binarySearch(int value) { //입력받은 값을 parameter로 받아옴
        int left = 0; //탐색하려는 배열의 제일 왼쪽
        int right = A.length - 1; //탐색하려는 배열의 제일 오른쪽
        int middle = (left + right) / 2;

        while (left <= right) { //cross(교차) 발생 방지
            if (value > middle) { //값이 중간값보다 크면 
                left =  middle + 1; //맨 왼쪽 위치를 중간값 +1로 이동 (탐색할 배열이 절반으로 줄어듦)
            } else if (value < middle) { //값이 중간값보다 작으면
                right = middle - 1; //맨 오른쪽 위치를 중간값 -1로 이동
            } else { //값이 중간값과 같다면 중간값을 리턴함
                return middle;
            }
        }
        return -1; //찾는 값이 없을 경우에는 -1을 리턴

    }
}
