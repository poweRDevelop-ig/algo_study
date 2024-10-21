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
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int max_5 = N / 5;
		for(int i = 0 ; i< max_5 +1;i++) {
			int sugar_total = N;
			sugar_total -= i * 5;
			int max_3 = sugar_total / 3;
			sugar_total -= 3 * max_3;
			if(sugar_total == 0) {
				min = min < i + max_3 ? min : i+max_3;
			}
		}
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else {
			System.out.println(min);
		}
	
	}
}
