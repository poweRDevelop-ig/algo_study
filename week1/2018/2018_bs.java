import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int startPoint = 1;
        int endPoint = 1;
        int sum = 1;
        int count =1;

        while (endPoint != n) {
            if(sum == n){
                count++;
                endPoint++;
                sum += endPoint;
            }
            else if(sum < n){
                endPoint++;
                sum += endPoint;
            }
            else{
                sum -= startPoint;
                startPoint++;
            }
        }
        System.out.println(count);
    }
}