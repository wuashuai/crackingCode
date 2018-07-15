package moderate;


/*LRU Cache: Design and build a "least recently used" cache, which evicts the least recently used
item. The cache should map from keys to values (allowing you to insert and retrieve a value associated
with a particular key) and be initialized with a max size. When it is full, it should evict the least
recently used item.*/

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V>{
    private int size;

    public LRUCache(int size){
        super(size, 0.5f, true);

        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }


    public static void main(String[] args){
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 1);
        cache.put(3, 3);

        System.out.println(cache);
    }

}

