
package jatek;

import java.util.Random;
import java.util.Scanner;

public class CsigasJatek extends Jatek{
    
    private static final Scanner SCN = new Scanner(System.in);
    private static final Random RND = new Random();
    
    private Csiga[] csigak = new Csiga[3];
    private String fogadas;
    
    public CsigasJatek(){
        try{
            csigak[0] = new Csiga("PIROS");
            csigak[1] = new Csiga("KEK");
            csigak[2] = new Csiga("ZOLD");
        }
        catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
        fogadasBeker();
        verseny();
        kiir();
    }
    
    private void fogadasBeker(){
        System.out.print("Fogadj (\"PIROS\", \"KEK\", \"ZOLD\"): ");
        this.fogadas = SCN.nextLine();
    }
    
    private void verseny(){
        for(int i = 0; i<5; i++){
            int nitroNum = RND.nextInt(0,5);
            for(int j = 0; j<csigak.length; j++){
                csigak[j].csigaGO(nitroNum == j);
            }
        }
    }
    
    private int winnerIndex(){
        int indexOfMax = 0;
        for(int i = 1; i<csigak.length; i++){
            if(csigak[i].getTraveledRoad().length() > csigak[indexOfMax].getTraveledRoad().length()){
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }
    
    private void kiir(){
        for(int i = 0; i<csigak.length; ++i){
            String colorCode = "\u001B[0m";
            switch(csigak[i].getColor()) {
                case "PIROS":
                    colorCode="\u001B[31m";
                    break;
                case "KEK":
                    colorCode="\u001B[34m";
                    break;
                case "ZOLD":
                    colorCode="\u001B[32m";
                    break;
            }
            System.out.println(colorCode+""+csigak[i].getTraveledRoad()+" @//\u001B[0m");
        }
        System.out.println("\nA nyertes csiga a "+csigak[winnerIndex()].getColor());
        System.out.printf("A fogadást %s\n", csigak[winnerIndex()].getColor().equals(fogadas)?"megnyerted":"elveszítetted");
    }
}
