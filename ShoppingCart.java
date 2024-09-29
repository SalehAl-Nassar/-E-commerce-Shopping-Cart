/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Saleh
 */
    import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements ShoppingCartOperations{
private List<CartItem> cartItems;


    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        // Check if product is already in the cart
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeItem(int productId) {
        cartItems.removeIf(item -> item.getProduct().getId() == productId);
    }

    @Override
    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Shopping Cart:");
            for (CartItem item : cartItems) {
                System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity() + " - Price: " + item.getProduct().getPrice());
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }
}


