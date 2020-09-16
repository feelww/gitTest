public class test3 {
    private static int[] start = {1,3,0,5,3,5,6,8,8,2,12};
    private static int[] end = {4,5,6,7,8,9,10,11,12,13,14};
    private static boolean[] flag = new boolean[start.length];

    private static int greedySelector(){
        flag[0] = true;
        int i = 0;
        int count = 1;
        for(int j = 1; j < start.length; j ++){
            if(start[j] >= end[i]){
                flag[j] = true;
                i = j;
                count ++;
            }
            else
                flag[j] = false;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print("活动的标号为：    ");
        for(int i = 0; i < start.length; i ++) System.out.printf("%3d ",i + 1);
        System.out.println();
        System.out.print("活动的开始时间为：");
        for(int i = 0; i < start.length; i ++) System.out.printf("%3d ",start[i]);
        System.out.println();
        System.out.print("活动的结束时间为：");
        for(int i = 0; i < end.length; i ++) System.out.printf("%3d ",end[i]);
        System.out.println();
        System.out.println();

        int count = greedySelector();
        System.out.println("当前活动的相容度为： " + count);
        System.out.print("相容的活动是： ");
        for(int i = 0; i < start.length; i ++)
            if(flag[i])
                System.out.print( (i + 1) + " ");
    }
}
