import static java.lang.StrictMath.floor;
import java.util.Arrays;

public class HashTable {
    long a;
    long c;
    long m;
    int loadCount = 0;


    // public for testing purposes
    public int buckets[];

    public HashTable(long _a, long _c, long _m) {
        this.a = _a;
        this.c = _c;
        this.m = _m;
        buckets = new int [(int)m];
        Arrays.fill(buckets, -1);

    }

    public void insert(int key) {
        if(loadFactor() == 1.0){
            extend();
        }
        int pos = (int)hash(key);
        boolean found = false;
        while(found == false){
            if(buckets[pos] == -1){
                buckets[pos] = key;
                loadCount += 1;
                found = true;
            }
            else if(buckets[pos] > 0){ //If position is already occupied by a positive integer
                pos = (pos + 1) % buckets.length;
                continue;
            }
        }
    }

    public void extend(){
        int temp[] = new int[buckets.length * 2];
        m = temp.length;
        Arrays.fill(temp, -1);
        for(int i = 0; i < buckets.length; i++){
            int pos = (int)hash(buckets[i]);
            temp[pos] = buckets[i];
        }
        buckets = temp;
    }

    public boolean find(int key) {
        int pos = (int)hash(key);
        int end = 0;
        while(end < buckets.length){
            if(buckets[pos] == key){
                return true;
            }
            else{
                pos = (pos + 1) % buckets.length;
                end += 1;
            }
        }
        return false;
    }

    public void remove(int key) {
        int pos = (int)hash(key);
        int end = 0;
        while(end < buckets.length){
            if(buckets[pos] == key){
                buckets[pos] = -1;
                loadCount -= 1;
            }
            else{
                pos = (pos + 1) % buckets.length;
                end += 1;
            }
        }
    }

    public double loadFactor() {
        double l = (int) buckets.length;
        return loadCount/l;
    }

    public long hash(int key){
        long h = (a * key + c) % m;
        return h;
    }

}
