/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.storehub;

/**
 *
 * @author aku
 */
class AccountBalancePayment extends Payment {

    public AccountBalancePayment(double accountBalance) {
        super(accountBalance);
    }

    @Override
    public boolean pay(double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
            return true;
        }
        return false;
    }
}