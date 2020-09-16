import java.util.Scanner;

public class test4 {
    private static int n = 8;
    private static int[] q = new int[n];
    private static int errorIndex = -100;

    private static boolean place(int x, int y){
        for(int i = 0; i < n; i ++)
            if(q[i] == y || (Math.abs(i - x) == Math.abs(q[i] - y)))
                return false;
        return true;
    }

    private static void nQueen(){
        int i = 1, j = 0;
        q[0] = 0;
        while(i < n){
            while (j < n){
                if(place(i, j)){
                    q[i] = j;
                    j = 0;
                    break;
                }
                else
                    j ++;
            }
            if(q[i] == errorIndex){
                if(i == 0) {
                    System.out.println();
                    System.out.printf("没有找到 "  + n +  " 皇后的解" );
                    break;
                }
                else{
                    i --;
                    j = q[i] + 1;
                    q[i] = errorIndex;
                    continue;
                }
            }
            if(i == n - 1){
                System.out.println();
                System.out.print("找到 " + n + " 皇后的一个解为： ");
                for(int k = 0; k < n; k ++)
                    System.out.print( (q[k] + 1) + " ");

                j = q[i] + 1;
                q[i] = errorIndex;
                continue;
            }
            i ++;
        }
    }

    public static void main(String[] args) {
        System.out.print("请输入一个数字，代表求解的 n 皇后问题的 n : ");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for(int i = 0; i < n; i ++) q[i] = errorIndex;

        nQueen();
    }
}
