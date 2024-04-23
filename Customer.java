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
public class Customer extends User {
    private boolean loggedIn;

    public Customer(String username, String email, String password) {
        super(username, email, password);
    }

    @Override
    public boolean authenticate(String password) {
        // Implement authentication logic
        return this.getPassword().equals(password);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    private Object getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
