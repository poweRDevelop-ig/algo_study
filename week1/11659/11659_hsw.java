import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hsw_11659 {
	static int [] arr;
    public static void main(String[] args) {
    	try {
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		StringBuilder sb = new StringBuilder();
        	String [] temp = br.readLine().split(" ");
        	int N = Integer.parseInt(temp[0]);
        	int M = Integer.parseInt(temp[1]);
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	arr = new int[N+1];
        	arr[0] = 0;
        	for(int i = 0; i< N ; i++) {
        		arr[i+1] = arr[i] + Integer.parseInt(st.nextToken());
        	}
        	
        	for(int i = 0 ; i < M; i ++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		sb.append(arr[b] - arr[a-1]).append("\n");
        		
        	}
        	System.out.println(sb);
    	}catch(Exception e){
    		
    	}
    	
    	
    }
}
