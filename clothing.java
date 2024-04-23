/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storehub;
/**
 *
 * @author Afzaal isnaufal
 */
public class clothing extends Produk {
    private String size;

    // Konstruktor
    public clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    // Getter dan setter untuk size (dan yang lainnya jika diperlukan)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

