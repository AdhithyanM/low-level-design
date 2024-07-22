import java.util.*;

public class FIFOCache implements Cache {
    private final int capacity;
    private final Map<String, String> cache;

    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>() {
            // note that this linked hash map maintains order based on insertion and not based on access
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > FIFOCache.this.capacity;  // eviction policy.
            }
        };
    }

    @Override
    public void add(String key, String value) {
        cache.put(key, value);
    }

    @Override
    public String remove(String key) {
        return cache.remove(key);
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }

    @Override
    public void display() {
        System.out.println("FIFO Cache Contents: ");
        cache.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
