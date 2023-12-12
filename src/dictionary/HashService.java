package dictionary;

/**
 *
 * @author cagri
 */
public class HashService {

    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;

    public HashService(int capacity) {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }


    public int getSize() {
        return currentSize;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    private int hash(String key) {
        return key.hashCode() % maxSize;
    }

    public void resize(int newCapacity) {
        
    }

    public void insert(String key, String val) {
        // Resize the hash table if the load factor exceeds 0.75

    }

    public String get(String key) {
        
    }

    public void remove(String key) {
        
    }

    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++) {
            if (keys[i] != null) {
                System.out.println(keys[i] + " " + vals[i]);
            }
        }
        System.out.println();
    }
}
