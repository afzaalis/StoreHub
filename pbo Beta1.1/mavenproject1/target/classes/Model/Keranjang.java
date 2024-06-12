package Model;

import java.util.ArrayList;
import java.util.List;

public class Keranjang {
    private int userId;
    private List<Product> items;

    public Keranjang(int userId) {
        this.userId = userId;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int getTotalItems() {
        return items.size();
    }

    public List<Product> getItems() {
        return items;
    }

    public int getUserId() {
        return userId;
    }

}
