import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] numbers={1,2,3};
    static int max =0;
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i =0;i<N;i++){
            int limit = Integer.parseInt(br.readLine() );
            backtracking(0, limit);

            System.out.println(max);
            max = 0;
        }

        br.close();
    }

    private static void backtracking(int now, int limit) {
    for(int i = 0; i<3;i++){
        int t_num = now;
        t_num += numbers[i];
        if( t_num > limit) return;
        else if(t_num == limit) {
            max +=1;
            return;
        }else{
            backtracking(t_num,limit);
        }

    }
    }


}


