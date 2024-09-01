package cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache implements Cache {
    private final int capacity;
    private final Map<String, Node> cache; // key to node mapping
    private final Map<Integer, LinkedHashSet<String>> freqMap; // frequency to keys mapping
    private int minFreq;

    class Node {
        String key;
        String value;
        int freq;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.freq = 1;  // Initial frequency is 1
        }
    }

    public LFUCache(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFreq = 0;
    }


    @Override
    public void add(String key, String value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            get(key);  // to update the frequency
            return;
        }
        if(cache.size() == capacity) {
            String evitKey = freqMap.get(minFreq).iterator().next();
            freqMap.get(minFreq).remove(evitKey);
            cache.remove(evitKey);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        freqMap.putIfAbsent(1, new LinkedHashSet<>());
        freqMap.get(1).add(key);
        minFreq = 1;
    }

    @Override
    public String remove(String key) {
        if(!cache.containsKey(key)) return null;
        Node node = cache.get(key);
        // remove the key from current freq level
        removeKeyFromFrequencyLevel(key, node.freq);
        // remove from cache
        cache.remove(key);
        return node.value;
    }

    @Override
    public String get(String key) {
        if(!cache.containsKey(key)) {
            return null;
        }
        Node node = cache.get(key);
        // remove the key from current freq level
        removeKeyFromFrequencyLevel(key, node.freq);
        node.freq++;
        // put the node to next freq level
        freqMap.putIfAbsent(node.freq, new LinkedHashSet<>());
        freqMap.get(node.freq).add(key);
        return node.value;
    }

    private void removeKeyFromFrequencyLevel(String key, Integer freq) {
        freqMap.get(freq).remove(key);
        // update minFreq in case if this key is the least frequent used and there is no other keys present in that frequency
        if(freqMap.get(minFreq).isEmpty() && minFreq == freq) {
            minFreq++;
        }
    }

    @Override
    public void display() {
        System.out.println("LFU cache.Cache Contents: ");
        for (int i = 1; i <= cache.size(); i++) {
            if(freqMap.containsKey(i)) {
                System.out.println("Freq: " + i + ": " + freqMap.get(i));
            }
        }
    }
}
