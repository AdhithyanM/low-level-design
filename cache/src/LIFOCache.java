import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LIFOCache implements Cache {
    private final int capacity;
    private final Map<String, String> cache;

    public LIFOCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, false) {
            // access order is set to false as we need to maintain insertion order
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                // Always return false because we manage removals manually in add method
                return false;
            }
        };
    }

    @Override
    public void add(String key, String value) {
        if(cache.size() == capacity) {
            Iterator<String> iterator = cache.keySet().iterator();
            String mostRecentKey = null;
            while(iterator.hasNext()) {
                mostRecentKey = iterator.next();
            }
            if(mostRecentKey != null) {
                cache.remove(mostRecentKey);
            }
        }
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
        System.out.println("LIFO Cache Contents: ");
        cache.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
