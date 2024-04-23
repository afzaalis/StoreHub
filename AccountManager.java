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
public interface AccountManager {
    boolean register(String username, String email, String password);
    boolean login(String username, String password);
    void logout();
}

