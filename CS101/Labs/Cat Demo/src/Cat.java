public class Cat {
    private String name, color;
    private float weight;
    
    public Cat() {
        this.name = "";
        this.color = "";
        this.weight = 0.0f;
    }
    
    public Cat(String n, String c, float w){
        this.name = n;
        this.color = c;
        this.weight = w;
    }
  
    public String getName() {
        return name;
    }
    
    public void setName(String n) {
        this.name = n;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public String toString() {
        return "My cat: " + this.name + " is " +
                this.color + " and weighs " + this.weight
                + " lbs.";
    }
    
}
