/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Glowstick;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class GlowsticksDAO {

    public ArrayList<Glowstick> getAllGlowsticks() {

        ArrayList<Glowstick> glowsticks = new ArrayList();

        Glowstick glowstickOne = new Glowstick(1, "Regular Glowstick", "Great for parties and social events!", 2.99, 120, "Purple", "10cm", "Glowstick1.png", "Regular");
        Glowstick glowstickTwo = new Glowstick(2, "Bracelet Glowstick", "Stylish and great fun with friends!", 4.99, 600, "Yellow", "15cm", "Glowstick2.jpg", "Bracelet");
        Glowstick glowstickThree = new Glowstick(3, "Military Glowstick", "For those tactical nights...", 50.00, 2000, "Green", "12cm", "Glowstick3.jpg", "Military");
        Glowstick glowstickFour = new Glowstick(4, "Diving Glowstick", "For the adventurous!", 45.00, 800, "Blue", "6cm", "Glowstick4.jpg", "Diving");

        glowsticks.add(glowstickOne);
        glowsticks.add(glowstickTwo);
        glowsticks.add(glowstickThree);
        glowsticks.add(glowstickFour);

        return glowsticks;
    }

    public Glowstick getGlowstickByID(int glowstickID) {

        for (Glowstick glowstick : getAllGlowsticks()) {
            if (glowstick.getGlowstickID() == glowstickID) {
                return glowstick;
            }
        }
        return null;
    }

    public Glowstick getGlowstickByColour(String colour, String size) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Glowstick getGlowstickByColourAndSize(String colour, String size) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
