import java.util.*;

public class hashTest{
    public static void main(String[] args) {
      //  System.out.println(args[0]);
    int set[] = {1, 2, 3, 4, 5};
    HashTable test1 = new HashTable(11342, 11630, 60095);
    // for(var i = 0; i < set.length; i++){
    //     test1.insert(set[i]);
    // }
    //System.out.println(Arrays.toString(test1.buckets));
    //System.out.println(test1.find(4));
    //System.out.println(test1.find(6));
    //test1.remove(4);
    //System.out.println(Arrays.toString(test1.buckets));
    System.out.println(test1.hash(33548254));
    }
}