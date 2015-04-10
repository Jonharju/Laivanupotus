
package Ohjelmalogiikka;

public class Peli {
    Pelikentta kentta1;
    Pelikentta kentta2;
    Laivasto laivat1;
    Laivasto laivat2;
    int vuoro;

    public Peli() {
        this.kentta1 = new Pelikentta();
        this.kentta2 = new Pelikentta();
        this.laivat1 = new Laivasto();
        this.laivat2 = new Laivasto();
        this.vuoro = 1;
    }
    public void vuoro(int x, int y){
        int vuoro = kummanVuoro();
        if(vuoro == 1) {
            
        } else {
            
        }
    }
    
    public void vaihdaVuoro(){
        vuoro++;
    }
    
    public int kummanVuoro() {
        if(this.vuoro%2 == 0){
            return 2;
        } else {
            return 1;
        }
    }
    
    public boolean loppuikoPeli(){
        if(!laivat1.onkoKaikkiUponnut() || !laivat2.onkoKaikkiUponnut()){
            return false;
        } else {
            return true;
        }
    }
    
    
}
