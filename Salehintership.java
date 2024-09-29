/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author Saleh
 */
public class Salehintership {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        // Sample products
        Product product1 = new Product(1, "Laptop", 999.99);
        Product product2 = new Product(2, "Smartphone", 499.99);
        Product product3 = new Product(3, "Headphones", 49.99);

        boolean running = true;

        while (running) {
            System.out.println("\n1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Products:");
                    System.out.println("1. " + product1.getName() + " - $" + product1.getPrice());
                    System.out.println("2. " + product2.getName() + " - $" + product2.getPrice());
                    System.out.println("3. " + product3.getName() + " - $" + product3.getPrice());
                    break;
                case 2:
                    try {
                        System.out.print("\nEnter Product ID to add to cart: ");
                        int productId = scanner.nextInt();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();

                        if (quantity <= 0) {
                            throw new IllegalArgumentException("Quantity must be greater than zero.");
                        }

                        if (productId == 1) cart.addItem(product1, quantity);
                        else if (productId == 2) cart.addItem(product2, quantity);
                        else if (productId == 3) cart.addItem(product3, quantity);
                        else throw new InvalidProductException("Invalid Product ID.");
                    } catch (InvalidProductException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 4:
                    double total = cart.calculateTotal();
                    System.out.println("Total Amount: $" + total);
                    System.out.println("Thank you for your purchase!");
                    running = false;
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
    