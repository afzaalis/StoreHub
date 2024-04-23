/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storehub;

/**
 *
 * @author Afzaal isnaufal
 */
public class book extends Produk {
    private String author;

    // Konstruktor
    public book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    // Getter dan setter untuk author (dan yang lainnya jika diperlukan)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

