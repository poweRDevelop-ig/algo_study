package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
* 첫째 줄에 회의의 수 N을 입력
* 둘째줄부터 N+1 줄까지 회의의 정보 입력?
* 공백을 사이에 두고 회의 시작 시간과 끝나는 시간 입력
* 시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.
* */

/* 활동선택문제(Activity Selection problem)
*  한 사람이 하나의 활동에 대해서만 작업할 수 있을 때 최대한 많은 활동을 할 수 있는 수를 선택
* 여기서는 회의가 겹치지 않게 최대한 많은 회의를 배정하는 것으로 나옴
*
* 이러한 문제들의 특징은 '한 사람이 하나의 활동에서만 작업할 수 있다'는 점
* 즉, 하나의 활동을 완료하기 전까지는 다른 활동을 선택할 수 없다.
* 하나의 활동을 선택하면 나머지 겹치지 않는 활동에 대해서 독립적이고,
* '탐욕 선택이 이후의 결과에 영향을 미치지 않는다.'
*
* 이전의 선택 결과가 이후의 결과에 영향을 미치지 않으려면
* 1. '이전 선택의 종료 시간'과 '이후 선택의 시작 시간'이 서로 겹치지 않아야 한다.
* 2. 최대한 많은 활동을 선택하려면 종료시간이 빨라야 한다.
*
* 따라서 종료시간을 기준으로 정렬을 하는 것이 좋다.
* 그후 종료시간에 대해 겹치는 것들은 제외하고 남은 것들 중에서 선택한다.
* */

public class Problem_1931 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
        time[][0] 은 시작 시점을 의미
        time[][1] 은 종료 시점을 의미
        */

        int[][] time = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken()); //시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); //종료시간
        } //N개의 회의 수에서 시작시간과 종료시간을 입력한 후 배열에 저장

        //종료시간을 기준으로 정렬해야 하므로 compare 재정의
        Arrays.sort(time, new Comparator<int[]>() { //이런 게 있는 줄 몰라서 찾아봐야함
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬한다

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prev_end_time = 0;

        for (int i = 0; i < N; i++) {
            //직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if (prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
