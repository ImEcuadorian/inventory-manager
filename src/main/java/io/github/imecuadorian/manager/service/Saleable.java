package io.github.imecuadorian.manager.service;

import io.github.imecuadorian.manager.exception.*;

public interface Saleable<K> {

    void saleable(K key, int quantity) throws InsufficientStockException;

}
