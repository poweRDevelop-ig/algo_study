package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}
public class Main {
	static int [] result;
	static boolean [] visit;
	static int V;
	static int E;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	V = Integer.parseInt(st.nextToken());
    	E = Integer.parseInt(st.nextToken());
    	int start = Integer.parseInt(br.readLine());
    	
    	result = new int[V+1];
    	visit = new boolean[V+1];
    	List<Node>[] list = new List[V+1]; 
    	
    	for(int i = 1; i <= V; i++) {
    		list[i] = new ArrayList<Node>();
    		result[i] = Integer.MAX_VALUE;
    	}
    	
    	for(int i = 0; i <E; i ++ ) {
    		st = new StringTokenizer(br.readLine());
    		int first = Integer.parseInt(st.nextToken());
    		int second = Integer.parseInt(st.nextToken());
    		int weight = Integer.parseInt(st.nextToken());
    	
    		list[first].add(new Node(second, weight));
    	}
    	
    	PriorityQueue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.weight - o2.weight);
    	result[start] = 0;
    	queue.add(new Node(start,0));
    	
    	while(!queue.isEmpty()) {
    		Node now = queue.poll();
    		if(!visit[now.end]) visit[now.end] = true;
    		
    		for(int i =0;i<list[now.end].size();i++) {
    			Node next = list[now.end].get(i);
    			
    			if(!visit[next.end] && now.weight + next.weight < result[next.end]) {
    				
    				result[next.end] = now.weight + next.weight;
    				
    				queue.add(new Node(next.end, result[next.end]));
    			}
    		}  
    	}
    	for(int i = 1; i< result.length;i++) {
    		System.out.println((result[i]!=Integer.MAX_VALUE)?result[i] : "INF");
    	}
    }
}


