/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package storehub;

/**
 *
 * @author Afzaal isnaufal
 */
public interface ProductManagement {
    void addProduct(Produk product);
    void editProduct(String productName, double newPrice);
    void deleteProduct(String productName);
    Produk findProductByName(String productName);
}
