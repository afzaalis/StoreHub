/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storehub;

/**
 *
 * @author Afzaal isnaufal
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductManager implements ProductManagement {
    private List<Produk> productList;

    // Konstruktor
    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    // Implementasi metode dari interface ProductManagement
    @Override
    public void addProduct(Produk product) {
        productList.add(product);
    }

    @Override
    public void editProduct(String productName, double newPrice) {
        for (Produk product : productList) {
            if (product.getName().equals(productName)) {
                product.setPrice(newPrice);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(String productName) {
        Iterator<Produk> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Produk product = iterator.next();
            if (product.getName().equals(productName)) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public Produk findProductByName(String productName) {
        for (Produk product : productList) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}

