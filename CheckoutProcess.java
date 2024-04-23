/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp.storehub;

/**
 *
 * @author aku
 */
interface CheckoutProcess {
    double calculateTotal();
    boolean processPayment(Payment payment);
}
