package Theme6_1;

public class QuadProbing <K, V>{
    private int N = 0, M = 13;
    private K[] a = (K[]) new Object[M];
    private V[] d = (V[]) new Object[M];
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    private void put(K key, V data) {
        int intialpos = hash(key);
        int i = intialpos, j = 1, loop_limit = 20;
        do{
            if(a[i] == null) {
                a[i] = key;
                d[i] = data; N++;
                return;
            }
            if(a[i].equals(key)) {
                d[i] = data;
            }
            i = (intialpos + j*j++) % M;
            loop_limit -= 1;
        }while(loop_limit > 0);
    }
    private V get(K key) {
        int intialpos = hash(key);
        int i = intialpos, j = 1, loop_limit = 20;
        while(a[i] != null & loop_limit > 0) {
            if(a[i].equals(key)) return d[i];
            i = (intialpos + j*j++) % M;
            loop_limit -= 1;
        }
        return null;
    }
}
