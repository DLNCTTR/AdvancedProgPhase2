
package Models;


public class Glowstick {
    
    
    private int glowstickID;
    private String name;
    private String description;
    private double price;
    private int duration;
    private String colour;
    private String size;
    private String image;
    private String type;

    public Glowstick(int id, String name, String description, double price, int duration, String colour, String size, String image, String type) {
        
        this.glowstickID = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.colour = colour;
        this.size = size;
        this.image = image;
        this.type = type;
    }

    
    public int getGlowstickID() {
        return glowstickID;
    }
    
    public void setGlowstickID(int id) {
        this.glowstickID = id;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
      public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
     public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
     public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    boolean getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
