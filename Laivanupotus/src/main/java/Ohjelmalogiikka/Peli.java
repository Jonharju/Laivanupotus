
package Ohjelmalogiikka;

/**
 *
 * @author Jonas
 */
public class Peli {

    public Pelikentta kentta1;

    public Pelikentta kentta2;

    public Laivasto laivat1;

    public Laivasto laivat2;

    public String nimi1;

    public String nimi2;

    public int vuoro;

    /**
     * Alustetaan kentät, laivat ja nimet kahdelle pelaajalle ja asetetaan vuoron numeroksi 1
     */
    public Peli() {
        this.kentta1 = new Pelikentta();
        this.kentta2 = new Pelikentta();
        this.laivat1 = new Laivasto();
        this.laivat2 = new Laivasto();
        this.nimi1 = "";
        this.nimi2 = "";
        this.vuoro = 1;
    }
    
    /**
     * Kasvatetaan vuoroa yhdellä
     */
    public void vaihdaVuoro(){
        vuoro++;
    }
    
    /**
     * Palauttaa vuoron perusteella kumman pelaajan vuoro
     * 
     * @return pelaajan numero jonka vuoro
     */
    public int kummanVuoro() {
        if(this.vuoro%2 == 0){
            return 2;
        } else {
            return 1;
        }
    }
    
    /**
     * Tarkistaa molempien pelaajien laivastojen tilan ja palauttaa peli loppu 
     * jos toisen laivaston kaikki laivat ovat uponneet
     * 
     * @return päättyikö peli
     */
    public boolean loppuikoPeli(){
        if(!laivat1.onkoKaikkiUponnut() || !laivat2.onkoKaikkiUponnut()){
            return false;
        } else {
            return true;
        }
    }
    
    
}
