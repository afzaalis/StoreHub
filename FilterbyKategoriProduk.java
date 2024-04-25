/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author M GALANG PRADWITA
 */
public class FilterbyKategoriProduk extends ProductFilter{
    @Override
    public List<Produk> filter(List<Produk> products, String keyword) {
        List<Produk> filteredProducts = new ArrayList<>();
        for (Produk product : products) {
            if (product.getCategory().contains(keyword)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
