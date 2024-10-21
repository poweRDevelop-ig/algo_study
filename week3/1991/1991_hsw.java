package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class tree{
	String L_child;
	String R_child;
	public tree( String l_child, String r_child) {
		L_child = l_child;
		R_child = r_child;
	}
	
}
public class Main {
	static ArrayList<tree> trees;
	static HashMap<String,tree> temp;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        trees = new ArrayList<tree>();
        temp = new HashMap<String, tree>();
        StringTokenizer st;
        for(int i = 0 ; i < N;i++) {
        	st = new StringTokenizer(br.readLine());
        	String a = st.nextToken();
        	String b = st.nextToken();
        	String c = st.nextToken();
        	temp.put(a, new tree(b,c));
        }
        
        
        
        front_print("A");
        System.out.println();
        middle_print("A");
        System.out.println();
        back_print("A");
        
    }
    static void front_print(String str) {
    	System.out.print(str);
    	if(!temp.get(str).L_child.equals(".") ) {
    		front_print(temp.get(str).L_child);
    	}
    	if(!temp.get(str).R_child.equals(".") ) {
    		front_print(temp.get(str).R_child);
    	}
    }
    static void middle_print(String str) {
    	if(!temp.get(str).L_child.equals(".") ) {
    		middle_print(temp.get(str).L_child);
    	}
    	System.out.print(str);
    	if(!temp.get(str).R_child.equals(".") ) {
    		middle_print(temp.get(str).R_child);
    	}
    }
    static void back_print(String str) {
    	if(!temp.get(str).L_child.equals(".") ) {
    		back_print(temp.get(str).L_child);
    	}
    	if(!temp.get(str).R_child.equals(".") ) {
    		back_print(temp.get(str).R_child);
    	}
    	System.out.print(str);
    	
    }
    
}

