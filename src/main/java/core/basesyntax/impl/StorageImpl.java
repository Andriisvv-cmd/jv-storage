package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_COUNT = 10;
    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        keys = (K[]) new Comparable[MAX_ELEMENTS_COUNT];
        values = (V[]) new Comparable[MAX_ELEMENTS_COUNT];
        count = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && keys[i] != null && keys[i].equals(key)) {
                values[i] = value;
                return;
            } else if (key == null && keys[i] == null) {
                values[i] = value;
                return;
            }
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                count++;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && keys[i] != null && keys[i].equals(key)) {
                return values[i];
            }
            if (key == null && keys[i] == null) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
