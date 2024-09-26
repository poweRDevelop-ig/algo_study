import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.util.Collections.swap;

public class 2750_wmj {
    public static void main(String[] args) throws IOException {

        //몇 개 입력 받을지 N 입력
        //N개의 수 입력 받아서 ascending order 정렬
        //버블정렬 연습

        /*버블 정렬은 두 인접한 값을 비교하여 정렬하는 방법
        * 간단한 알고리즘이지만 정렬할 리스트의 크기가 커질 수록 성능이 저하됨
        * 이미 정렬된 배열에 대해 모든 비교가 필요하므로 비효율적인 정렬 알고리즘 중 하나다.
        * 최악의 경우 시간 복잡도가 O(n^2)가 되어 비효율적일 수 있음
        * 따라서, 큰 크기의 리스트에서는 다른 정렬 알고리즘을 고려하는게 좋다
        * 리스트가 역순으로 정렬되어 있는 경우, 버블 정렬은 매번 인접한 요소를 교환해야 하므로 비효율적이다.
        * */

        //수가 중복되지 않는다고 해서 set을 썼는데 틀렸다고 함
        //검색해보니 중복되지 않게 하라고 한 게 아니라서, set을 쓸 필요가 없다고 함
        //Collections.sort를 썼는데 출력초과가 나옴
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //몇 개 입력할지

        int[] intArray = new int[N]; // N개의 길이를 가지는 배열 intArray를 선언

        for (int i = 0; i < N; i++) { //intArray에 들어갈 요소를 입력함
            intArray[i] = Integer.parseInt(br.readLine());
        }



        /*일반적인 버블정렬 방법*/
        for (int i = 0;  i <N-1 ; i++) { //마지막 요소는 이미 정렬되었으므로 비교하지 않음 그래서 N-1까지
            for (int j = N - 1; j > i; j--) { //정렬되지 않은 부분만을 대상으로 비교하므로 N-1부터 시작함
                if (intArray[j] < intArray[j-1]) { //j번째와 인접한 j-1을 비교
                    int temp = intArray[j]; //임시 변수에 기존 j의 요소 담음
                    intArray[j] = intArray[j-1]; //j번째에 j-1번째 요소가 들어감
                    intArray[j-1] = temp; //기존에 담아뒀던 j요소가 j-1로 들어가서 두 요소의 값을 바꿈
                }
            }
        }

        /* 버블정렬을 더 효율적으로 사용하는 방법은
        교환횟수를 활용한 방법과 교환이 일어난 마지막 위치를 파악하는 방법이 있음*/

        for (int i : intArray) {
            System.out.println(i);
        }

//        System.out.println(Arrays.toString(intArray));
        /*
        Arrays.toString(intArray))를 사용하면 배열의 모든 요소를 한꺼번에 출력
        결과가 너무 길거나 포맷이 잘못되면 출력 초과가 발생할 수 있음
        */

    }
}

