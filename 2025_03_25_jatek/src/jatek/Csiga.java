
package jatek;

import java.util.Random;

public class Csiga {
    
    private static final Random RND = new Random();

    private String color;
    private String  traveledRoad = "";
    
    public Csiga(String color){
        setColor(color);
    }
    
    private void setColor(String color){
        
        switch(color) {
            case "PIROS":
            case "KEK":
            case "ZOLD":
                this.color = color;
                break;
            default:
                throw new IllegalArgumentException("A megadott szín ("+color+") nem \"PIROS\", \"KEK\" vagy \"ZOLD\"");
        }
    }
    public void csigaGO(boolean nitro){
        int iMax = RND.nextInt(0,4);
        if(nitro){
            iMax *= 2;
            for(int i = 0; i<iMax; ++i){
                this.traveledRoad += "->";
            }
        }
        else{
            for(int i = 0; i<iMax; ++i){
                this.traveledRoad += ">";
            }
        }
        this.traveledRoad += ",";
    }
    public String getTraveledRoad(){
        return traveledRoad;
    }
    public String getColor(){
        return this.color;
    }
}
