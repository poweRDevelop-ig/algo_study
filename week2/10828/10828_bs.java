import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    int n = Integer.parseInt(st.nextToken());

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String x= st.nextToken();
      if(x.equals("push")){
        int y = Integer.parseInt(st.nextToken());
        stack.push(y);
      }
      else if(x.equals("pop")){
        if(stack.isEmpty()){
          sb.append(-1).append("\n");
        }else {
          sb.append(stack.peek()).append("\n");
          stack.pop();

          // 간단하게 sb.append(stack.pop()).append("\n");를 해도 pop이 되면서 StringBuilder에 추가가 된다.
        }
      }
      else if (x.equals("size")){
        sb.append(stack.size()).append("\n");
      }
      else if(x.equals("empty")){
        if(stack.isEmpty()){
          sb.append(1).append("\n");
        }
        else{
          sb.append(0).append("\n");
        }
      }
      else if(x.equals("top")){
        if(stack.isEmpty()){
          sb.append(-1).append("\n");
        }
        else{
          sb.append(stack.peek()).append("\n");
        }
      }
    }
    System.out.println(sb);
  }
}

/*
답지 확인 : X
n의 수는 10,000까지의 수만 있으므로 반복문 1개가 필요한 이 로직에서 시간복잡도는 O(n)이다.
제한 시간은 0.5초이기 때문에 1초의 연산은 50,000,000까지 가능하기 때문에 시간 초과는 일어나지 않으리라 생각 했다.
그 후는 값을 처음 값을 입력한 걸 비교하고 push가 나왔을 때 추가 값을 입력할 수 있게 해주었고,
나머지는 그에 맞게 조건을 달아주어 문제를 해결하였다.

간단하게 sb.append(stack.pop()).append("\n");를 해도 pop이 되면서 StringBuilder에 추가가 된다.

 */