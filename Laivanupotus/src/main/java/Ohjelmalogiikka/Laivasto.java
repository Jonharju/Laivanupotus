
package Ohjelmalogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonas
 */
public class Laivasto {

    /**
     *
     */
    public List<Laiva> laivat;

    /**
     *
     */
    public Laivasto() {
        this.laivat = new ArrayList<Laiva>() {};
        laivat.add(new Laiva(5));
        laivat.add(new Laiva(4));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(3));
        laivat.add(new Laiva(2));
        laivat.add(new Laiva(1));
    }
    
    /**
     * Käydään laiva kerrallaan läpi onko ruudussa laiva
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     * 
     * @return onko laivaston laiva tässä ruudussa
     */
    public boolean onkoJoLaiva(int x, int y, int koko, int suunta){
        for(int i = 0; i < koko; i++){
            for(Laiva l : laivat){
                if(suunta == 0){
                    if(l.onkoLaivaTassa(x, y+i)){
                        return true;
                    }
                } else if(suunta == 1) {
                    if(l.onkoLaivaTassa(x+i, y)){
                        return true;
                    }
                }
                
            }
        }
        return false;
    }
    
    /**
     * Tarkistaa yksitellen ovatko kaikki laivat uponneet ja palauttaa tuloksen
     * 
     * @return ovatko kaikki laivat uponneet
     */
    public boolean onkoKaikkiUponnut(){
        for(Laiva l : laivat){
            if(!l.uponnut()){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Tarkistaa laiva kerrallaan osuiko näihin koordinaatteihin ammuttu johonkin laivoista
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     * 
     * @return osuiko johonkin laivoista
     */
    public boolean osuiko(int x, int y){
        for(Laiva l : laivat){
            if(l.osuiko(x, y)){
                return true;
            }
        }
        return false;
    }
    
    public boolean onkoKaikkiAsetettu(){
        for(Laiva l : laivat){
            if(!l.onkoAsetettu()){
                return false;
            }
        }
        return true;
    }
}
