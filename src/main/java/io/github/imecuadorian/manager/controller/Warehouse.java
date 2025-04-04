package io.github.imecuadorian.manager.controller;

import io.github.imecuadorian.manager.model.*;
import io.github.imecuadorian.manager.service.*;

import java.util.*;

public class Warehouse implements Service<String, Product>, Saleable<String> {

    private final List<Product> products = new ArrayList<>();

    public void setNameSynonyms(String code, String... synonyms) {
        Optional<Product> productOpt = getById(code);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setNameSynonyms(synonyms);
        } else {
            System.out.println("Product with ID " + code + " not found.");
        }
    }

    @Override
    public void getAll() {
        this.products.forEach(product -> {
            System.out.println("ID: " + product.getCode());
            System.out.println("Name: " + product.getName());
            if (product.getNameSynonyms() != null) {
                System.out.println("Synonyms: " + Arrays.toString(product.getNameSynonyms()));
            }
            System.out.println("Model: " + product.getModel());
            System.out.println("Brand: " + product.getBrand());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("---------------------------");
        });
    }

    @Override
    public void add(Product value) {
        this.products.add(value);
    }

    @Override
    public Optional<Product> getById(String key) {
        return this.products.stream()
                .filter(product -> product.getCode().equals(key))
                .findFirst();
    }

    @Override
    public void addStock(String key, int quantity) {
        Optional<Product> productOpt = getById(key);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            int currentQuantity = product.getQuantity();
            product.setQuantity(currentQuantity + quantity);
            System.out.println("Stock updated! New quantity: " + product.getQuantity());
        } else {
            System.out.println("Product with ID " + key + " not found.");
        }
    }

    @Override
    public void saleable(String key, int quantity) {
        Optional<Product> productOpt = getById(key);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= quantity) {
                product.setQuantity(currentQuantity - quantity);
                System.out.println("Purchase successful! Remaining quantity: " + product.getQuantity());
            } else {
                System.out.println("Insufficient stock! Current quantity: " + currentQuantity);
            }
        } else {
            System.out.println("Product with ID " + key + " not found.");
        }
    }
}
