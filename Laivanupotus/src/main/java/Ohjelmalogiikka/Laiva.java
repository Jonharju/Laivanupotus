
package Ohjelmalogiikka;

/**
 *
 * @author Jonas
 */
public class Laiva {
    private int x;
    private int y;
    private int suunta;
    private int koko;
    private int osumia;
    private boolean asetettu;

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSuunta() {
        return suunta;
    }

    public int getOsumia() {
        return osumia;
    }

    public boolean isAsetettu() {
        return asetettu;
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
        
    /**
     *
     * @return onko laiva jo asetettu
     */
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
        if(x > 9 || y > 9){
            return false;
        }
        if(suunta == 0){
            if(y+koko-1 <= 9){
                return true;
            }
        } else if(suunta == 1) {
            if(x+koko-1 <= 9){
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
            System.out.println("Osuit laivaan");
            if(uponnut()){
                System.out.println("Upotit laivan!");
            }
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
        if(onkoAsetettu()){
            if(this.suunta == 0) {
                if(this.x == x){
                    for(int i = 0; i < this.koko;i++){
                        if(y == this.y + i){
                            return true; 
                        }
                    }
                } 
            } else if(this.suunta == 1){
                if(this.y == y){
                    for(int i = 0; i < this.koko;i++){
                        if(x == this.x + i){
                            return true; 
                        }
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

    /**
     *
     * @return laivan koko
     */
    public int getKoko() {
        return koko;
    }
    
}
