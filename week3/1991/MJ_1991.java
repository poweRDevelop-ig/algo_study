package week3;

///*
//* 트리 순회
//* 첫째 줄에 이진 트리의 노드의 개수 N (1 <= N <= 26) 입력
 //* 둘째 줄에 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드 입력
//* 항상 A가 루트 노드, 노드의 이름은 A부터 차례대로 알파벳 대문자
//* 자식 노드가 없는 경우 .으로 표현
//*
//* 출력할 때는
//* 첫째 줄 : 전위순회
//* 둘째 줄 : 중위순회
//* 셋째 줄 : 후위순화
//* N개의 알파벳을 공백없이 출력
//* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1991 {
    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;

        }
    }
    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<n+1; i++) {
            String[] line = br.readLine().split(" ");
            int data = line[0].charAt(0) -'A'+1;
            int left = line[1].charAt(0) -'A'+1;
            int right = line[2].charAt(0) -'A'+1;
            list[data].add(new Node(left, right));
        }

        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        System.out.println(sb.toString());

    }

    // 전위 순회 root > left > right
    static void preorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            sb.append((char)(start+'A'-1));
            if(l != -18) preorder(l);
            if(r != -18) preorder(r);
        }
    }

    // 중위 순회 left > root > right
    static void inorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -18) inorder(l);
            sb.append((char)(start+'A'-1));
            if(r != -18) inorder(r);
        }
    }

    // 후위 순회 left > right > root
    static void postorder(int start) {
        for(Node node : list[start]) {
            int l = node.left;
            int r = node.right;

            if(l != -18) postorder(l);
            if(r != -18) postorder(r);
            sb.append((char)(start+'A'-1));
        }
    }
}
