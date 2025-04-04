package io.github.imecuadorian.manager.model;

public class Product {

    private Generic<String, Integer> product;
    private Generic<String, String> supplier;
    private Generic<Double, ?> price;

    public Product(String code, String name, String model, String brand, double price, int quantity) {
        this.product = new Generic<>(code, name, quantity);
        this.supplier = new Generic<>(model, brand);
        this.price = new Generic<>(price);
    }

    public String getCode() {
        return this.product.getT1();
    }

    public String getName() {
        return this.product.getT2();
    }

    public int getQuantity() {
        return this.product.getS1();
    }

    public String getModel() {
        return this.supplier.getT1();
    }

    public String getBrand() {
        return this.supplier.getS1();
    }

    public double getPrice() {
        return this.price.getT1();
    }

    public void setCode(String code) {
        this.product.setT1(code);
    }

    public void setName(String name) {
        this.product.setT2(name);
    }

    public void setQuantity(int quantity) {
        this.product.setS1(quantity);
    }

    public void setModel(String model) {
        this.supplier.setT1(model);
    }

    public void setBrand(String brand) {
        this.supplier.setT2(brand);
    }

    public void setPrice(double price) {
        this.price.setT1(price);
    }

    public void setSupplier(String supplier) {
        this.supplier.setT2(supplier);
    }

    public void setNameSynonyms(String... synonyms) {
        this.product.setArray(synonyms);
    }

    public String[] getNameSynonyms() {
        return this.product.getArray();
    }
}
