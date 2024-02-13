/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem newItem) {
        boolean found = false;
    for (CartItem item : items) {
        if (item.getGlowstick().getId() == newItem.getGlowstick().getId()) {
            item.setQuantity(item.getQuantity() + newItem.getQuantity());
            found = true;
            break;
        }
    }
    if (!found) {
    items.add(newItem);
    }
}

    public void removeItem(int glowstickID) {
        items.removeIf(item -> item.getGlowstick().getId() == glowstickId);
}

     public double getTotalCost() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getGlowstick().getPrice() * item.getQuantity();
        }
        return total;
     }
     public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}