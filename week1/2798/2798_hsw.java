
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
    public static void main(String[] args) {
    	try {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int max = 0;
        	st = new StringTokenizer(br.readLine());
        	arr = new int[N];
        	for(int i = 0; i < N;i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	
        	for(int i = 0 ;i<N-2;i++) {
        		for(int j=1;j<N-1;j++) {
        			for(int k=2;k<N;k++) {
        				if(i!=j && j!=k && i!=k) {
        					int sum = arr[i]+arr[j]+arr[k];
            				if(max < sum && sum <=M) {
            					max = sum;
            				}
        				}
        				else {
        					continue;
        				}
        			}
        		}
        	}
        	System.out.println(max);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    }
}