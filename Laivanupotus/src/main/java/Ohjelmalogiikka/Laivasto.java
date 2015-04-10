
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
    
    public boolean onkoJoLaiva(int x, int y){
        for(Laiva l : laivat){
            if(l.onkoLaivaTassa(x, y)){
                return true;
            }
        }
        return false;
    }
    
    public boolean onkoKaikkiUponnut(){
        for(Laiva l : laivat){
            if(!l.uponnut()){
                return false;
            }
        }
        return true;
    }
    
    public boolean osuiko(int x, int y){
        for(Laiva l : laivat){
            if(l.osuiko(x, y)){
                return true;
            }
        }
        return false;
    }
}
