/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storehub;

/**
 *
 * @author Afzaal isnaufal
 */
public class electronics extends Produk {
    private String brand;

    // Konstruktor
    public electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    // Getter dan setter untuk brand (dan yang lainnya jika diperlukan)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

