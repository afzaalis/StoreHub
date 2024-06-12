package Model;

public class Pakaian extends Product {
    public Pakaian(int id, String namaProduk, double harga, String deskripsi) {
        super(id, "Pakaian", namaProduk, harga, deskripsi);
    }
    
    @Override
    public String getDetails() {
        return "Clothing Details:\n" +
               "ID: " + getId() + "\n" +
               "Category: " + getCategory() + "\n" +
               "Name: " + getName() + "\n" +
               "Price: " + getPrice() + "\n" +
               "Description: " + getDescription();
    }
}