import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int from;
	int to;
	int cost;
	
	public Node(int from,int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}
public class Main {
	static int V,E;
	static PriorityQueue<Node> nodes;
	static int[] parents;
    public static void main(String[] args) throws IOException {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         nodes = new PriorityQueue<Node>();

         V = Integer.parseInt(br.readLine()); // 정점 수
         E = Integer.parseInt(br.readLine()); // 간선 수
         parents = new int[V+1];
         for (int i = 0; i < E; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             int from = Integer.parseInt(st.nextToken());
             int to = Integer.parseInt(st.nextToken());
             int cost = Integer.parseInt(st.nextToken());

             nodes.add(new Node(from, to, cost)); // 노드 리스트에 추가
         }

        
    	make(parents);
    	
    	
    	int sum = 0;
    	while(!nodes.isEmpty()) {
    		Node node = nodes.poll();
    		if(union(node.from, node.to)) {
    			sum += node.cost;
    		}
    	}
    	System.out.println(sum);
    }
    
    public static boolean union(int from, int to) {
    	int fromRoot = findSet(from);
    	int toRoot = findSet(to);
    	
    	if(fromRoot == toRoot) return false;
    	else parents[toRoot] = fromRoot;
    	return true;
    }
    
    //부모찾기 - 유니온 파인드 알고리즘과 동일 
    private static int findSet(int v) {
    	if(parents[v] == v) return v;
    	else return parents[v] = findSet(parents[v]);
    }
    public static void make(int[] parents) {
    	for(int i = 1; i<= V;i++) {
    		parents[i] = i;
    	}
    }
}

