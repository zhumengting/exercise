package com.zmt.exercise.important;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU<K, V> {
    private LinkedHashMap<K, V> map;
    private int index;

    public LRU(int size) {

        map = new LinkedHashMap<K, V>(size, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return super.removeEldestEntry(eldest);
            }
        };
    }

    public V add(K key, V value) {
        if (index < map.size()) {
            map.put(key, value);
        }
        return value;
    }

}
