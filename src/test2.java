public class test2 {
    private static char[] x = {' ','a','b','c','b','d','a','b'};
    private static char[] y = {' ','b','d','c','a','b','a'};
    private static int[][] b = new int[x.length][y.length];

    private static void pri(int i, int j){
        if(i == 0 || j == 0) return;
        if(b[i][j] == 1){
            pri(i - 1, j - 1);
            System.out.print(x[i] + " ");
        }
        else if(b[i][j] == 2)
            pri(i - 1, j);
        else
            pri(i ,j - 1);
    }

    private static int[][] LCS() {
        int[][] c = new int[x.length][y.length];
        for(int i = 0; i < x.length; i ++) c[i][0] = 0;
        for(int i = 0; i < y.length; i ++) c[0][i] = 0;

        for(int i = 1; i < x.length; i ++){
            for(int j = 1; j < y.length; j ++){
                if(x[i] == y[j]){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.print("数组 x 为：");
        for(int i = 0; i < x.length; i ++) System.out.print(x[i] + " ");
        System.out.println();
        System.out.print("数组 y 为：");
        for(int i = 0; i < y.length; i ++) System.out.print(y[i] + " ");
        System.out.println();
        System.out.println();

        int[][] c = LCS();
        System.out.println("x 和 y 的最长公共子序列长度为 : " + c[x.length - 1][y.length - 1]);
        System.out.print("x 和 y 的最长公共子序列为： ");
        pri(x.length - 1, y.length - 1);

        System.out.println("\n");
        System.out.println("数组 c 为： ");
        for(int i = 0; i < x.length; i ++) {
            for (int j = 0; j < y.length; j++)
                System.out.print(c[i][j] + " ");
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("数组 b 为： ");
        for(int i = 0; i < x.length; i ++) {
            for (int j = 0; j < y.length; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
    }
}
