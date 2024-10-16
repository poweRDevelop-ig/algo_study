package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] population;
	static HashMap<Integer, ArrayList<Integer>> line;
	static int N;
	static ArrayList<List<Integer>> comblist;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		line = new HashMap<Integer, ArrayList<Integer>>();
		
		st = new StringTokenizer(br.readLine());
		//각 마을별 인구 수 
		for(int i = 0; i < N ; i ++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		//각 마을별 연관 지역 
		for(int i = 0; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			line.put(i+1, new ArrayList<Integer>());
			int count = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < count; j ++) {
				line.get(i+1).add(Integer.parseInt(st.nextToken()));
			}
		}
//		System.out.println(line);
		//조합이 dfs를 통해 가능한 집합인지 구하기
		for(int i=1;i<N/2+1;i++) {
//			System.out.println("here " + i);
			comblist = getComb(N,i);
			for(List<Integer> temp : comblist) {
				int value = can_dfs_check(temp);
				min = min < value ? min : value; 
			}
		}
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}	
	
	public static ArrayList<List<Integer>> getComb(int N, int r ){
		comblist = new ArrayList<List<Integer>>();
		int[] arr = new int[N];
		for(int i = 0 ; i < N;i++) {
			arr[i] = i+1;
		}
		List<Integer> combinationList = new ArrayList<Integer>();
		combination(arr, combinationList, 0,r);
//		System.out.println(comblist);

		return comblist;
	}
	public static void combination(int[] arr, List<Integer> combinationList, int start, int r) {
        if (r == 0) {
            comblist.add(new ArrayList<>(combinationList)); // 조합의 복사본을 추가
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            combinationList.add(arr[i]);
            combination( arr, combinationList, i + 1, r - 1);
            combinationList.remove(combinationList.size() - 1);
        }
    }
	
	public static int can_dfs_check(List<Integer> temp) {
	    int blue_sum = population[temp.get(0) - 1]; // 시작 노드의 인구 수 추가

		int red_sum = 0;
		boolean [] checked = new boolean[N+1];  
		
		Stack<Integer> stk = new Stack<Integer>();
		stk.add(temp.get(0));
		checked[temp.get(0)] = true;
		while(!stk.empty()) {
			int top = stk.pop();
			for(int i : line.get(top)) {
				if(!checked[i] && temp.contains(i)) {
					checked[i] = true;
					blue_sum += population[i-1];
					stk.add(i);
				}
			}
		}
//		System.out.println("blue check");
//		for(int i =0;i<checked.length;i++) {
//			System.out.print(checked[i] + " ");
//		}
//		System.out.println();
		
		int other = -1;
		for(int i = 1 ; i < checked.length;i++) {
			if(!checked[i] && !temp.contains(i)) {
				other = i;
				break;
			}
		}
//		System.out.println("i am other " + other);
		
		stk = new Stack<Integer>();
		stk.add(other);
		checked[other] = true;
	    red_sum += population[other - 1];

		while(!stk.empty()) {
			int top = stk.pop();
			for(int i : line.get(top)) {
				if(!checked[i] && !temp.contains(i)) {
					checked[i] = true;
					red_sum += population[i-1];
					stk.add(i);
				}
			}
		}
//		System.out.println("red check");
//		for(int i =0;i<checked.length;i++) {
//			System.out.print(checked[i] + " ");
//		}
//		System.out.println();
//		System.out.println();
		for(int i = 1 ; i < checked.length;i++) {
			if(!checked[i]) {
				return Integer.MAX_VALUE;
			}
		}
		
		return Math.abs(blue_sum -red_sum);
		  
	}
}

