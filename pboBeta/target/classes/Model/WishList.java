/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Afzaal isnaufal
 */
public class WishList {
    private int userId;
    private List<Product> wList;

    public WishList(int userId) {
        this.userId = userId;
        this.wList = new ArrayList<>();
    }

    public List<Product> getwList() {
        return wList;
    }

    public void setwList(List<Product> wList) {
        this.wList = wList;
    }
    
    public void addItem(Product product) {
        wList.add(product);
    }
    
    public void removeItem(Product product) {
        wList.remove(product);
    }
   
    
}
