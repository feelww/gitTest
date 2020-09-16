import java.util.Random;

public class test1 {
    private static int num = 5;
    private static int[] aList = new int[num];
    private static int count = 0;


    private static void swapList(int a, int b){
        int t = aList[a];
        aList[a] = aList[b];
        aList[b] = t;
    }

    private static void sortList(int l, int r){
        if(l >= r)
            return;

        int flag = (int) (Math.random() * (r - l)) + l;
        swapList(l,flag);

        int i,j;
        for(i = l + 1, j = r; ; ){
            while(aList[i] < aList[l] && i < r)
                i ++;
            while(aList[j] > aList[l])
                j --;
            if(i >= j)
                break;
            swapList(i,j);
        }

        swapList(j,l);

        sortList(l,j-1);
        sortList(j+1, r);
    }

    public static void main(String[] args) {
        Random random = new Random();
        for(int i = 0; i < num; i ++)
            aList[i] = random.nextInt(10);
        System.out.print("排序之前的序列为： ");
        for(int i = 0; i < num; i ++)
            System.out.print(aList[i] + " ");
        System.out.println();

        sortList(0, num - 1);

        System.out.println();
        System.out.print("完整排序之后的序列为： ");
        for(int i = 0; i < num; i ++)
            System.out.print(aList[i] + " ");
    }
}
