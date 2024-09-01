package cache;

public class Main {
    public static void main(String[] args) {
        Cache lruCache = CacheFactory.getCache(EvictionPolicy.LRU, 3);
        lruCache.add("A", "1");
        lruCache.add("B", "2");
        lruCache.add("C", "3");
        lruCache.display();
        lruCache.add("D", "4");
        lruCache.display();
        System.out.println("Accessed B: " + lruCache.get("B"));
        lruCache.display();
        lruCache.add("E", "5");
        lruCache.display();

        // try for other cache by creating cache using cache.CacheFactory specifying eviction policy.
    }
}
