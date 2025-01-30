package problemsforhashmapshashfunctions.implementingcustomhashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashMap<K,V> {
    // The size of the hash map
    private final int SIZE = 16;
    // The buckets to store key-value pairs
    private ArrayList<LinkedList<Entry<K, V>>> buckets;

    // Constructor to initialize the buckets
    public CustomHashMap() {
        buckets = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    // Method to get the bucket index for a given key
    public int getBucketIndex(K key) {
        return key.hashCode() % SIZE;
    }

    // Method to add a key-value pair to the hash map
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Update value if key already exists
                entry.value = value;
                return;
            }
        }
        // Add new entry if key does not exist
        bucket.add(new Entry<>(key, value));
    }

    // Method to get the value for a given key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Return value if key is found
                return entry.value;
            }
        }
        // Return null if key is not found
        return null;
    }

    // Method to remove a key-value pair from the hash map
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets.get(bucketIndex);

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                // Store value to return later
                V value = entry.value;
                // Remove entry from the bucket
                bucket.remove(entry);
                // Return removed value
                return value;
            }
        }
        // Return null if key is not found
        return null;
    }

    // Method to display all key-value pairs in the hash map
    public void display() {
        System.out.println("Key\tValue");
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                System.out.println(entry.key + "\t" + entry.value);
            }
        }
    }
}
