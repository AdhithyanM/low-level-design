public class CacheFactory {
    public static Cache getCache(EvictionPolicy evictionPolicy, int capacity) {
        return switch (evictionPolicy) {
            case LRU -> new LRUCache(capacity);
            case LFU -> new LFUCache(capacity);
            case FIFO -> new FIFOCache(capacity);
            case LIFO -> new LIFOCache(capacity);
        };
    }
}
