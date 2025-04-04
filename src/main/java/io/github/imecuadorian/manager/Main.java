package io.github.imecuadorian.manager;

import io.github.imecuadorian.manager.controller.*;
import io.github.imecuadorian.manager.model.*;
import io.github.imecuadorian.manager.util.*;

import java.util.*;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Warehouse WAREHOUSE = new Warehouse();
    private static final String MENU = """
            
            Inventory Managment System
            
            1. Add Product
            2. List Products
            3. Register Sale
            4. Manage Stock
            0. Exit
            
            Enter your choice:
            
            """;

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        String choice;
        do {
            System.out.print(MENU);
            choice = SCANNER.nextLine();
            do {
                if (Validate.isValidateInteger(choice)) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    choice = SCANNER.nextLine();
                }
            } while (true);
            switch (choice) {
                case "1" -> addProduct();
                case "2" -> WAREHOUSE.getAll();
                case "3" -> registerSale();
                case "4" -> manageStock();
                case "0" -> {
                    System.out.println("Exiting...");

                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("0"));
    }

    private static void manageStock() {
        System.out.println("Managing stock...");
        System.out.print("Enter product code: ");
        String code = SCANNER.nextLine();
        System.out.print("Enter quantity to add: ");
        String quantityInput = SCANNER.nextLine();
        int quantity = Integer.parseInt(quantityInput);
            WAREHOUSE.addStock(code, quantity);
    }

    private static void registerSale() {
        System.out.println("Registering a sale...");
        System.out.print("Enter product code: ");
        String code = SCANNER.nextLine();
        System.out.print("Enter quantity sold: ");
        String quantityInput = SCANNER.nextLine();
        int quantity = Integer.parseInt(quantityInput);
        try {
            WAREHOUSE.saleable(code, -quantity);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addProduct() {
        System.out.println("Registering a new product...");
        System.out.print("Enter product code: ");
        String code = SCANNER.nextLine();
        System.out.print("Enter product name: ");
        String name = SCANNER.nextLine();
        System.out.println("Enter product synonyms (separated by semicolon(;)): ");
        String synonymsInput = SCANNER.nextLine();
        String[] synonyms = synonymsInput.split(";");
        System.out.print("Enter product model: ");
        String model = SCANNER.nextLine();
        System.out.print("Enter product brand: ");
        String brand = SCANNER.nextLine();
        System.out.print("Enter product price: ");
        String priceInput = SCANNER.nextLine();
        double price = Double.parseDouble(priceInput);
        System.out.print("Enter product quantity: ");
        String quantityInput = SCANNER.nextLine();
        int quantity = Integer.parseInt(quantityInput);
        Product product = new Product(code, name, model, brand, price, quantity);
        WAREHOUSE.add(product);
        WAREHOUSE.setNameSynonyms(code, synonyms);
    }
}
