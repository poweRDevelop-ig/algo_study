package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int[] parents;
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args) throws IOException {
        arr = new ArrayList<ArrayList<Integer>>();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N= Integer.parseInt(br.readLine());
        for(int i =0;i<=N;i++) {
        	arr.add(new ArrayList<Integer>());
        }
        
        for(int i = 0 ; i < N-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr.get(a).add(b);
        	arr.get(b).add(a);
        }
        parents = new int[N+1];
        visited = new boolean[N+1];
        find(1);
        
        for(int i = 2; i<=N;i++) {
        	System.out.println(parents[i]);
        }
    }
    private static void find(int currentNode) {
    	visited[currentNode] = true;
    	for(int a : arr.get(currentNode)) {
    		if(!visited[a]) {
    			parents[a] = currentNode;
    			find(a);
    		}
    	}
    }
}

