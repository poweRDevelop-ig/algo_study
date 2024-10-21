package week3;

/*
* 집합의 표현
* n - 입력으로 주어지는 연산의 개수
* m - 각각의 연산
*
* 합집합은 0 a b 형태로 입력
*
* */

/*
   유니온 파인드
   이름 그대로 합집합 찾기
   대표적인 그래프 알고리즘
   상호 배타적 집합(Disjoint-set)라고도 함
   여러 노드가 존재할 때, 두 개의 노드를 선택해서 현재 두 노드가
   서로 같은 그래프에 속하는지 판별하는 알고리즘이다

   두 가지 연산으로 이루어져 있음
   Find : x가 어떤 집합에 포함되어 있는지 찾는 연산
   Union : x와 y가 포함되어 있는 집합을 합치는 연산

   여러 개의 노드를 합칠 때(union), 예를 들어 1,2,3을 합치면
   1과 3은 부모가 다르기 때문에 1과 3이 연결되었는지 파악하기 힘들다
   이 때 재귀함수를 사용한다. 3의 부모인 2를 찾고, 2의 부모인 1을 찾아서
   결과적으로 3의 부모가 1임을 파악한다.
   그 외의 설명은 생략하고 블로그를 참고할 것 : https://brenden.tistory.com/33
*/

import java.io.*;
import java.util.StringTokenizer;

public class Problem_1717 {

    static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //연산의 개수인 N을 입력
        int M = Integer.parseInt(st.nextToken()); //각각의 연산 M

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else if (command == 1) {
                sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x]) { //보낸 매개변수의 값이 부모배열의 값과 같다면, 즉 부모라면
            return x; //x를 바로 리턴
        }

        return parent[x] = find(parent[x]); //그게 아니면, 부모를 찾아서 리턴함
    }

    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    // x와 y의 부모가 같은지 확인
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return true;
        }

        return false;
    }


}
