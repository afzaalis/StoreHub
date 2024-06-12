package Model;

public class Elektronik extends Product {
    public Elektronik(int id, String namaProduk, double harga, String deskripsi) {
        super(id, "Elektronik", namaProduk, harga, deskripsi);
    }
    
    @Override
    public String getDetails() {
        return "Elektronik Details:\n" +
               "ID: " + getId() + "\n" +
               "Category: " + getCategory() + "\n" +
               "Name: " + getName() + "\n" +
               "Price: " + getPrice() + "\n" +
               "Description: " + getDescription();
    }
}