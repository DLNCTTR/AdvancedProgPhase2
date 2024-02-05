
package Service;

import DAO.GlowsticksDAO;
import Models.Glowstick;
import java.util.ArrayList;


public class GlowstickService {
    
    public ArrayList<Glowstick> getAllGlowsticks() {
        
        GlowsticksDAO glowsticks = new GlowsticksDAO();
        return glowsticks.getAllGlowsticks();
        
    }

    public Glowstick getGlowstickByID(int glowstickID) {
        
        GlowsticksDAO glowsticks = new GlowsticksDAO();
        Glowstick glowstick = glowsticks.getGlowstickByID(glowstickID);
        return glowstick;
        
    }

}
