package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ig_2018 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int count = 1;
		int startIn = 1;
		int endIn = 1;
		int sum = 1;
		while(endIn != num) {
			if(num == sum) {
				count++;
				endIn++;
				sum = sum + endIn;
			}
			else if(num < sum) {
				sum = sum - startIn;
				startIn++;
			}
			else if(num > sum) {
				endIn++;
				sum = sum + endIn;
			}
		}
		System.out.println(count);
	}

}
