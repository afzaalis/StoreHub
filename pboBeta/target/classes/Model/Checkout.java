package Model;

import java.util.List;

public class Checkout {
    private List<Product> checkoutItems; 
    private User user;

    public Checkout(User user, List<Product> checkoutItems) {
        this.user = user;
        this.checkoutItems = checkoutItems;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : checkoutItems) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    
    public int calculateTotalItems() {
        return checkoutItems.size();
    }

    public void performCheckout() {
        double totalPrice = calculateTotalPrice();
        double remainingBalance = user.getBalance() - totalPrice;
        if (remainingBalance >= 0) {
            user.setBalance(remainingBalance);
            System.out.println("Checkout successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
