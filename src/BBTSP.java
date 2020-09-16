public class BBTSP {
    private static float maxNum = Float.MAX_VALUE;
    private static float[][] a = {{maxNum,30,6,4},{30,maxNum,5,10},{6,5,maxNum,20},{4,10,20,maxNum}};

    public static float bbtsp(int[] v){
        int n = v.length - 1;
        MinHeap heap = new MinHeap(30);
        float[] minOut = new float[n + 1];
        float minSum = 0;
        for (int i = 0; i < n; i ++){
            float min = maxNum;
            for (int j = 0; j < n; j ++)
                if(a[i][j] < maxNum && a[i][j] < min)
                    min = a[i][j];
             if(min == maxNum) return maxNum;
             minOut[i] = min;
             minSum += min;
        }

        int[] x = new int[n];
        for (int i = 0; i < n; i ++) x[i] = i;
        HeapNode enode = new HeapNode(0,0,minSum,0, x);
        float bestc = maxNum;

        while(enode != null && enode.s < n - 1){
            x = enode.x;
            if (enode.s == n - 2){
                if(a[x[n-2]][x[n-1]] < maxNum && a[x[n-1]][x[0]] < maxNum
                && enode.cc + a[x[n-2]][x[n-1]] + a[x[n-1]][x[0]] < bestc){
                    bestc = enode.cc + a[x[n-2]][x[n-1]] + a[x[n-1]][x[0]];
                    enode.cc = bestc;
                    enode.lcost = bestc;
                    enode.s ++;
                    heap.put(enode);
                }
            }
            else{
                for(int i = enode.s + 1; i < n; i ++)
                    if(a[x[enode.s]][x[i]] < maxNum){
                        float cc = enode.cc + a[x[enode.s]][x[i]];
                        float rcost = enode.rcost - minOut[x[enode.s]];
                        float b = cc + rcost;
                        if(b < bestc){
                            int[] xx = new int[n];
                            for(int j = 0; j < n; j ++) xx[j] = x[j];
                            xx[enode.s + 1] = x[i];
                            xx[i] = x[enode.s + 1];
                            HeapNode node = new HeapNode(b,cc,rcost,enode.s+1,xx);
                            heap.put(node);
                        }
                    }
            }
            enode = (HeapNode) heap.removeMin();
        }

        for (int i = 0; i < n; i ++)
            v[i] = x[i];
        return bestc;
    }

    public static void main(String[] args) {
        System.out.println("图的邻接矩阵a为： ");
        for (int i = 0; i < a.length; i ++){
            for (int j = 0; j < a[i].length; j ++){
                if(a[i][j] == Float.MAX_VALUE)
                    System.out.printf("%3s  ", "MAX");
                else
                    System.out.printf("%3.0f  " , a[i][j] );
            }
            System.out.println();
        }

        System.out.println();
        int[] v = new int[a.length + 1];
        float bestc = bbtsp(v);
        if(bestc == maxNum){
            System.out.println("该图无回路");
            return;
        }
        System.out.println("最小代价为： " + bestc);
        System.out.print("所选的路径为： ");
        for (int i = 0; i < v.length; i ++)
            System.out.print( (v[i] + 1) + " ");
    }

}
