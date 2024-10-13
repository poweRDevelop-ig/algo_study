import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    static boolean [] checked;
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        // 얘가 1번노드부터 들어가서 마지막번호까지 들어갈 수 있기때문
        checked = new boolean[n+1];

        //여기까진 자료 초기화
        for(int i = 0 ; i< m;i++){
            String [] temp = br.readLine().split(" ");
            int first = Integer.parseInt(temp[0]);
            int second = Integer.parseInt(temp[1]);
            if (map.containsKey(first)){
                map.get(first).add(second);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(second);
                map.put(first, list);
            }
            if (map.containsKey(second)){
                map.get(second).add(first);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(first);
                map.put(second, list);
            }
        }
        stk.add(1);
        checked[1] = true;
        //거쳐간 상태인지 확인하고 거쳐간거면 pass 그게 아니면 stk에 추가
        while(!stk.isEmpty()){
            int temp = stk.pop();
            //pop한 녀석이 map에 존재할 경우
            if(map.containsKey(temp)){
                //map에 있는 값을 하나씩 돌려보면서
                for(int i : map.get(temp)){
                    if(!checked[i]){
                        checked[i] = true;
                        answer +=1;
                        //i와 연관된 애들을 다 스택에 넣는다
                        stk.add(i);
                }
            }
            }
        }
        System.out.println(answer);

    }
}
