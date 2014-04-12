/**
 *
 * @author Subrina
 */
public class Name {
    private String f, l, m;
    
    /**
     * Default constructor
     */
    public Name() {
        f = "";
        l = "";
        m = "";
    }
    
    public Name(String f, String l, String m) {
        this.f = f;
        this.l = l;
        this.m = m;
    }
    
    public String getF() {
        return f;
    }
    
    public void setF(String f){
        this.f = f;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }        
}
