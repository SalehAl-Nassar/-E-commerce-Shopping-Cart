/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Saleh
 */
public interface ShoppingCartOperations {
    public abstract void addItem(Product product, int quantity);
    public abstract void removeItem(int productId);
    public abstract void displayCart();
    public abstract double calculateTotal();
}
