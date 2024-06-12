package Model;

public class Buku extends Product {
    public Buku(int id, String namaProduk, double harga, String deskripsi) {
        super(id, "Buku" ,namaProduk, harga, deskripsi);
    }
    
    @Override
    public String getDetails() {
        return "Buku Details:\n" +
               "ID: " + getId() + "\n" +
               "Category: " + getCategory() + "\n" +
               "Name: " + getName() + "\n" +
               "Price: " + getPrice() + "\n" +
               "Description: " + getDescription();
    }
}