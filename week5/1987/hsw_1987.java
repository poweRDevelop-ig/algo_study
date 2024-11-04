import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Character[][] matrix;
    static boolean[] checked;
    static int [] row_move = {-1,0,1,0};
    static int [] col_move = {0,1,0,-1};
    static int max = 1;
    public static void main(String[] args) throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        matrix = new Character[R][C];
        checked = new boolean[30];
        for(int i =0 ;i< R;i++){
            String temp = br.readLine();
            for (int j = 0;j <C;j++){
                matrix[i][j] = temp.charAt(j);
            }
        }
        checked[matrix[0][0] - 65] = true;
        moving(0,0,1);
        System.out.println(max);
    }

    private static void moving(int row, int col, int cost) {

        int t_row;
        int t_col;
        for(int i =0;i<4;i++){
            t_row  = row + row_move[i];
            t_col = col + col_move[i];


            if(check(t_row,t_col)){
                checked[matrix[t_row][t_col] - 65] = true;
                cost +=1;
                moving(t_row, t_col,cost);

                checked[matrix[t_row][t_col] - 65] = false;
                cost -= 1;
            }
                max = Math.max(max, cost);


        }
    }

    static boolean check(int row, int col){
        //매트릭스에서 벘어나면
        if(row<0  || row >= matrix.length || col < 0 || col >= matrix[0].length){
            return false;
        }
        // 이미 다녀온 경로면
        if(checked[matrix[row][col] - 65]){
            return false;
        }
        return true;
    }
}


