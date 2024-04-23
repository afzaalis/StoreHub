/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.storehub;

/**
 *
 * @author aku
 */
class Checkout implements CheckoutProcess {
    private ShoppingCart cart;
    private double totalAmount;

    public Checkout(ShoppingCart cart) {
        this.cart = cart;
        this.totalAmount = cart.calculateTotal();
    }

    @Override
    public double calculateTotal() {
        return totalAmount;
    }

    @Override
    public boolean processPayment(Payment payment) {
        if (payment.pay(totalAmount)) {
            System.out.println("Payment successful. Remaining balance: " + payment.getAccountBalance());
            return true;
        } else {
            System.out.println("Insufficient account balance.");
            return false;
        }
    }
}
