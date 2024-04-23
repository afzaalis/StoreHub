/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitur.keranjang.belanja;

import java.util.List;

public class ShoppingCartImplementation {
    public static void main(String[] args) {
        UserCart cart = new UserCart();

        // Adding items to the cart
        Item item1 = new Item("Laptop", 800);
        Item item2 = new Item("Phone", 500);
        cart.addToCart(item1);
        cart.addToCart(item2);

        // Removing an item from the cart
        cart.removeFromCart(item1);

        // Displaying cart contents
        System.out.println("Cart contents:");
        List<Produk> contents = cart.getCartContents();
        for (Produk produk : contents) {
            System.out.println(produk.getName() + " - $" + produk.getPrice());
        }

        // Calculating total price
        double totalPrice = cart.calculateTotal();
        System.out.println("Total Price: $" + totalPrice);
    }
}
