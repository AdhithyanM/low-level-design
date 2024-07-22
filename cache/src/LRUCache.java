import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache implements Cache {
    private final int capacity;
    private final Map<String, String> cache;

    public LRUCache(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > LRUCache.this.capacity; // eviction policy
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
        System.out.println("LRU Cache Contents: ");
        cache.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
