import java.io.IOException;
import java.util.Scanner;
public class Main{
    static int pointer = -1;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        arr = new int[n];
        String code;
        for(int i =  0; i< n; i ++){
            code = sc.next();
            switch(code){
                case "push" :
                    int temp = sc.nextInt();
                    arr[++pointer] = temp;
                    break;
                case "pop" :
                    if(pointer==-1){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(arr[pointer--]).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(pointer+1).append("\n");

                    break;
                case "empty" :
                    if(pointer == -1)
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");

                    break;
                case "top":
                    if(pointer==-1){
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(arr[pointer]).append("\n");
                    }
                    break;

            }
        }
        System.out.println(sb);
        sc.close();
    }
}
