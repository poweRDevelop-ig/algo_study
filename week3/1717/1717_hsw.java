
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class Main {

	static int [] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N+1];
        for(int i =0;i<N+1;i++) {
        	graph[i] = i;
        }
        for(int i = 0; i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int check = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	if(check==0) {
        		union(a,b);
        	}else {
        		confirm(a,b);
        	}
        }
       
    }
    static int getParent(int x) {
    	if(graph[x] == x) return x;
    	return graph[x] = getParent(graph[x]);
    }
    static void union(int a, int b) {
    	a = getParent(a);
    	b = getParent(b);
    	if ( a<b) graph[b] = a;
    	else graph[a] = b;
    }
    static void confirm(int a, int b) {
    	a = getParent(a);
    	b = getParent(b);
    	if(a==b) System.out.println("YES");
    	else System.out.println("NO");
    }
}

