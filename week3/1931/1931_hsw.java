package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class ConferenceTime implements Comparable<ConferenceTime> {
    int start;
    int end;

    public ConferenceTime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(ConferenceTime other) {
        // 종료 시간이 같으면 시작 시간을 기준으로 정렬
        if (this.end == other.end) {
            return Integer.compare(this.start, other.start);
        }
        return Integer.compare(this.end, other.end);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ConferenceTime[] ctArr = new ConferenceTime[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ctArr[i] = new ConferenceTime(start, end);
        }

        // 회의를 종료 시간 기준으로 정렬 (종료 시간이 같으면 시작 시간 기준)
        Arrays.sort(ctArr);

        
        int count = 0;
        int lastEndTime = 0;

        // 가장 빨리 끝나는 회의부터 선택
        for (ConferenceTime ct : ctArr) {
            if (ct.start >= lastEndTime) {
                count++;
                lastEndTime = ct.end;
            }
        }

        System.out.println(count);
    }
}

