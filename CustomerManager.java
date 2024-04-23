/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StoreHub;

/**
 *
 * @author mrizk
 */
public class CustomerManager implements AccountManager {
    private Customer currentCustomer;

    @Override
    public boolean register(String username, String email, String password) {
        // Register logic, e.g., save to database
        currentCustomer = new Customer(username, email, password);
        return true; // Return success status
    }

    @Override
    public boolean login(String username, String password) {
        // Find customer in database
        // Authenticate the user
        if (currentCustomer != null && currentCustomer.getUsername().equals(username)) {
            if (currentCustomer.authenticate(password)) {
                currentCustomer.setLoggedIn(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout() {
        if (currentCustomer != null) {
            currentCustomer.setLoggedIn(false);
        }
    }
}
