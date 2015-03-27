
package Ohjelmalogiikka;

import java.util.ArrayList;

public class Laivasto {
    ArrayList<Laiva> laivat;

    public Laivasto() {
        this.laivat = new ArrayList<Laiva>();
        laivat.add(new Laiva(5));
        laivat.add(new Laiva(4));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(2));
        laivat.add(new Laiva(1));
    }
    
    public boolean onkoKaikkiUponnut(){
        boolean uponneet = true;
        for(Laiva l : laivat){
            uponneet = l.uponnut();
        }
        return uponneet;
    }
    public boolean osuiko(int x, int y){
        boolean osui = false;
        for(Laiva l : laivat){
            if(l.osuiko(x, y)){
                osui = true;
            }
        }
        return osui;
    }
}
