import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int goods = 0;
        int[] arr = new int[n];
        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);

        int len = arr.length - 1;

        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = arr.length - 1;

            while (start < end) {                       // start가 end의 값을 넘지 못하게 한다. => 결과적으로 같은 수를 계산하는 것이기 때문
                if(arr[start] + arr[end] == arr[i]) {
                    if(start != i && end != i){         // start 와 end가 자기 저산 (i)인지 확인 한다.
                        goods++;
                        break;
                    }
                    else if (start ==i){                // start가 i 이면 start ++ 해준다.
                        start++;
                    }
                    else {                              //  end가 i 아면 end -- 해준다.
                        end--;
                    }
                }
                else if(arr[start] + arr[end] < arr[i]) {   // sort 해줬기 떄문에 start + end 값이 i 보다 작으면 작은수를 키워줘야한다.
                    start++;
                }
                else if (arr[start] + arr[end] > arr[i]) {  // sort 해줬기 떄문에 start + end 값이 i 보다 크면 큰수를 줄여줘야한다.
                    end--;
                }
            }
        }
        System.out.println(goods);
    }
}
/*
해답 : O
해답을 본 이유는 문제를 푼 상황에서 시간초과가 뜬 이유였다.
계산을 해봤을 때 2000^2이면 충분히 가능한 시간대로 예상했는데 시간초과로 당황했었다.
이전에 내가 문제를 풀었을 때도 시간초과로 많이 오답을 내 틀렸던 흔적이 남아있었다.
이 문제는 투포인터 문제로 푸는 방식이였다
나는 처음에 while문 안에 for문으로 사용해 조건식을 걸어주었다.
그러나 for문 안에 있는 조건식이 장애를 일으킬 가능성이 있다고 하여 시간초과가 뜨는것 같았다.
문제 풀이는
1. for문으로 전체적인 n개의 수를 반복시켜준다.
2. start 와 end를 각각 만들어 준다. start는 0부터 시작을 하며 end 는 배열길이-1 을 해준다.
3. while문으로 start < end를 해준다. 그 이유는 각각의 수는 같으면 안된다는 조건이 있었으며, start 와 end가 바뀐다고 해도 계산은 달리지지 않아서이다.
4. start 와 end의 합이 배열의 i와 같은지 비교를 한다.
5. 같다면 s 와 e가 i와 같은지를 확인한다. => i와 같은수라 하면 자기 자신이 되기 때문에 제외 시켜야 한다.
6. 결과 값을 출력한다.
 */