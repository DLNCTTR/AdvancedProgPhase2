/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author dylan
 */
public class CartItem {
    private Glowstick glowstick;
    private int quantity;
    
    public CartItem(Glowstick glowstick, int quantity) {
        this.glowstick = glowstick;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Glowstick getGlowstick() {
        return glowstick;
    }

    public void setGlowstick(Glowstick glowstick) {
        this.glowstick = glowstick;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

