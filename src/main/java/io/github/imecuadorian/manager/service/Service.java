package io.github.imecuadorian.manager.service;

import java.util.*;

public interface Service<K, V>{
    void getAll();
    void add(V value);
    Optional<V> getById(K key);

    void addStock(K key, int quantity);

}
