/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitur.keranjang.belanja;

import java.util.ArrayList;
import java.util.List;

class UserCart implements ShoppingCart {
    private List<Product> cartItems;

    public UserCart() {
        cartItems = new ArrayList<>();
    }

    @Override
    public void addToCart(Produk produk) {
        cartItems.add(produk);
        System.out.println(product.getName() + " added to cart.");
    }

    @Override
    public void removeFromCart(Produk produk) {
        cartItems.remove(produk);
        System.out.println(produk.getName() + " removed from cart.");
    }

    @Override
    public List<Produk> getCartContents() {
        return cartItems;
    }

    @Override
    public double calculateTotal() {
        double total = 0;
        for (Produk item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }
}

