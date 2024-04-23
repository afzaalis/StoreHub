/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wishlist;

/**
 *
 * @author athal
 */
// UserWishlist.java
import java.util.ArrayList;
import java.util.List;

public class userwishlist implements WishlistManagement {
    List<Produk> wishlist;

    public userwishlist() {
        this.wishlist = new ArrayList<>();
    }

    @Override
    public void addProductToWishlist(Produk produk) {
        wishlist.add(produk);
        System.out.println(produk.name + " added to wishlist.");
    }

    @Override
    public void removeProductFromWishlist(Produk produk) {
        wishlist.remove(produk);
        System.out.println(produk.name + " removed from wishlist.");
    }

    @Override
    public void displayWishlist() {
        System.out.println("Wishlist:");
        for (Produk produk : wishlist) {
            System.out.println(produk.getProductDetails());
        }
    }
}

