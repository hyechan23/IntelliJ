package Theme6_1;

public class LinearProbing<K, V> {
    private int M = 13;
    private K[] a = (K[]) new Object[M];
    private V[] d = (V[]) new Object[M];
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    private void put(K key, V data) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        do {
            if (a[i] == null) {
                a[i] = key;
                d[i] = data;
                return;
            }
            if (a[i].equals(key)) {
                d[i] = data;
                return;
            }
            i = (initialpos + j++) % M;
        } while (i != initialpos);
    }
    public V get(K key) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        while (a[i] != null) {
            if(a[i].equals(key)) return d[i];
            i = (initialpos + j++) % M;
        }
        return null;
    }
}
