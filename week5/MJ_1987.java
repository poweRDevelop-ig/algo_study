package com.mjwoo.mybatis;

/*
    세로 R칸, 가로 C칸 보드
    각 칸에는 대문자 알파벳 하나씩, 1행 1열 - 말

    첫째줄에는 R칸, C칸 입력
    둘째줄에는 대문자알파벳 빈칸없이 입력

    말이 지날 수 있는 최대의 칸 수 출력

    백트래킹 - 가지치기
    모든 가능한 경우의 수 중에서 특정한 조건을 만족하는 경우만 살펴봄

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Algo_1987 {
    static int R; //세로 R
    static int C; //가로 C

    static int answer;
    static char[][] board; //가로 C칸, 세로 R칸만큼의 보드를 만듦
    static int[] dx = {-1, 1, 0, 0}; //움직일 수 있는 x값을 미리 배열에 넣어놓음
    static int[] dy = {0, 0, -1, 1}; //y값도 미리 배열에 넣어놓음 -
    static HashSet<Character> alphabet;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);  // 각 칸의 알파벳 입력
            }
        }

    }
    static void back(int x, int y, int count) {
        answer = Math.max(answer, count);  // 현재까지의 이동 칸 수와 최대값 비교
        alphabet.add(board[x][y]);  // 현재 알파벳을 방문 처리

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];  // 다음 x좌표
            int ny = y + dy[i];  // 다음 y좌표

            // 보드 범위 내에 있는지 확인
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                // 방문하지 않은 알파벳인 경우
                if (!alphabet.contains(board[nx][ny])) {
                    back(nx, ny, count + 1);  // 재귀 호출
                }
            }
        }
        alphabet.remove(board[x][y]);  // 현재 알파벳을 방문 해제
    }

}
