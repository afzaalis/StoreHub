/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author M GALANG PRADWITA
 */
public class Produk {
     private String name;
    private double price;
    private String category;

    // Konstruktor
    public Produk(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
