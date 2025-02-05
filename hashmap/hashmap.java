
import java.util.*;

public class hashmap<K, V> {

    private class Node {

        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private int n;  //key-value pairs
    private int N;  //number of buckets
    private LinkedList<Node> buckets[];  //array of linkedlist represents a bucket to handle collisions

    public hashmap() {
        this.N = 4;
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bi = hashFunction(key);  //bucket index
        int di = getIndexWithinBucket(key, bi);  //data index

        if (di != -1) {
            Node node = buckets[bi].get(di);
            node.value = value;
        } else {
            Node node = new Node(key, value);
            buckets[bi].add(node);
            n++;
        }

        double lambda = (double) n / N;
        if (lambda > 2.0) {
            rehash();
        }
    }

    private int hashFunction(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % N; //to avoid negative hashcode
        // The modulo operator % N ensures that the resulting index is within the bounds of the array of buckets. Specifically, it maps the hash code to a valid index in the range [0, N-1].
    }

    private int getIndexWithinBucket(K key, int bi) {
        for (int i = 0; i < buckets[bi].size(); i++) {
            if (buckets[bi].get(i).key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        buckets = new LinkedList[N * 2];
        N = N * 2;
        n = 0;

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (LinkedList<Node> oldBucket : oldBuckets) {
            for (Node node : oldBucket) {
                put(node.key, node.value);
            }
        }
    }

    public V get(K key) {
        int bi = hashFunction(key);  //bucket index
        int di = getIndexWithinBucket(key, bi);  //data index

        if (di != -1) {
            Node node = buckets[bi].get(di);
            return node.value;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        hashmap<String, Integer> map = new hashmap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);

        System.out.println("HashMap created and values added.");
        System.out.println(map.get("one"));
        System.out.println(map.get("two"));
        System.out.println(map.get("three"));
        System.out.println(map.get("four"));
        System.out.println(map.get("five"));
    }
}
