package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private int count;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (key != null && keys[i] != null && keys[i].equals(key)
                    || (key == null && keys[i] == null)) {
                values[i] = value;
                return; // виходимо, бо оновили
            }
        }
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                keys[i] = key;
                values[i] = value;
                return; // виходимо, бо додали
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
        count = 0;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                count++;
            }
        }
        return count;
    }
}
