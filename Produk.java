/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storehub;

/**
 *
 * @author Afzaal isnaufal
 */
public class Produk {
    private String name;
    private double price;

    // Konstruktor
    public Produk(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter dan setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
