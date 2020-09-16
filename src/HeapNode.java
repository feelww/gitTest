public class HeapNode implements Comparable{
    float lcost, cc, rcost;  // lcost为当前子树费用下界，  cc 为当前费用
    int s;  // 记录当前节点所处层次
    int[] x; // 记录需要进一步探索的节点

    HeapNode(float lc, float ccc, float rc, int ss, int[] xx){
        lcost = lc;
        cc = ccc;
        rcost = rc;
        s = ss;
        x = xx;
    }

    public int compareTo(Object x){
        float xlc = ((HeapNode) x).lcost;
        if(lcost < xlc) return -1;
        else if(lcost == xlc) return 0;
        else return 1;
    }
}
