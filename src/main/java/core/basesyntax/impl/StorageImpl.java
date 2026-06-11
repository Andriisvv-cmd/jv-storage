package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keys;
    private V[] values;
    private boolean[] occupied;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_CAPACITY];
        values = (V[]) new Object[MAX_CAPACITY];
        occupied = new boolean[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keys.length; i++) {
            if (occupied[i] && keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        for (int i = 0; i < keys.length; i++) {
            if (!occupied[i]) {
                keys[i] = key;
                values[i] = value;
                occupied[i] = true;
                return; // виходимо, бо додали
            }
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if (occupied[i] && keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < keys.length; i++) {
            if (occupied[i]) {
                count++;
            }
        }
        return count;
    }

    private boolean keysEqual(K a, K b) {
        return a == null ? b == null : a.equals(b);
    }
}
