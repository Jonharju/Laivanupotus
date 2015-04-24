
package Ohjelmalogiikka;

/**
 *
 * @author Jonas
 */
public class Laiva {
    int x;
    int y;
    int suunta;
    int koko;
    int osumia;
    boolean asetettu;

    /**
     * Alustetaan muuttujat, -1 jos ei vielä laitettu, kooksi koko ja osumia 0
     * 
     * @param koko laivalle annettu koko
     */
    public Laiva(int koko) {
        this.x = -1;
        this.y = -1;
        this.suunta = -1;
        this.koko = koko;
        this.osumia = 0;
        this.asetettu = false;
    }


    /**
     * Asetetaan annettujen mukaan, 0 pystyyn ja 1 vaakaan
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     * @param suunta käyttäjän antama syöte
     */
        public void asetaLaiva(int x, int y, int suunta){
        this.x = x;
        this.y = y;
        this.suunta = suunta;
        this.asetettu = true;
    }
        
    public boolean onkoAsetettu(){
        return this.asetettu;
    }


    /**
     * Tarkistetaan onko paikka laivalle sopiva, palautetaan true jos on ja false jos ei
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     * @param suunta käyttäjän antama syöte
     * 
     * @return mahtuuko laiva
     */
        public boolean sopiikoLaiva(int x, int y, int suunta){
        if(x > 10 || y > 10){
            return false;
        }
        if(suunta == 0){
            if(x+koko-1 <= 10){
                asetaLaiva(x,y,suunta);
                return true;
            }
        } else if(suunta == 1) {
            if(y+koko-1 <= 10){
                asetaLaiva(x,y,suunta);
                return true;
            }
        }
        return false;
    }

    /**
     * Lisää laivalle osuman
     */
    public void osu(){
        if(this.osumia < this.koko){
            this.osumia++;
        }
    }

    /**
     * Tarkistaa osuiko laukaus, eli onko laiva annetuissa koordinaateissa ja jos osui, nii lisätään laivalle osuma.
     * Sitten palautetaan käyttäjälle osuiko vai eikö
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     * 
     * @return osuiko laivaan
     */
    public boolean osuiko(int x, int y) {
        if(onkoLaivaTassa(x, y)){
            osu();
            return true;
        }
        return false;
    }
    
    /**
     * Tarkistaa käyttäjän antamien koordinaattien perusteella onko laiva kyseisessä paikassa
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     * 
     * @return onko laiva tässä paikassa
     */
    public boolean onkoLaivaTassa(int x, int y){
        if(this.suunta == 0) {
            if(this.y == y){
                for(int i = 0; i < this.koko;i++){
                    if(x == this.x + i){
                        return true; 
                    }
                }
            } 
        } else if(this.suunta == 1){
            if(this.x == x){
                for(int i = 0; i < this.koko;i++){
                    if(y == this.y + i){
                        return true; 
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Palauttaa onko laiva uponnut vai eikö
     * 
     * @return onko laiva uponnut
     */
    public boolean uponnut(){
       return this.osumia == this.koko;
    }
    
}
