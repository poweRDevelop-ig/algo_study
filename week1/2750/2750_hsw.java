import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        arr = new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = s.nextInt();
        }
        b_sort(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }

    private static void b_sort(int[] arr) {
        int temp;
        int n = arr.length;
        for(int i = n-1;i>0;i--){
            for(int j = 0; j <i;j++){
                if(arr[j]<arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}


