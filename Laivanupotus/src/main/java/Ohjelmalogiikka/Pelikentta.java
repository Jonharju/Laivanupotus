
package Ohjelmalogiikka;

/**
 *
 * @author Jonas
 */
public class Pelikentta {
    private int [][] pelikentta;

    /**
     * Luodaan tyhjä kenttä ja alustetaan se
     */
    public Pelikentta() {
        this.pelikentta = new int[10][10];
        alustaKentta();
    }
    
    /**
     * Asetetaan jokainen kentän ruutu ampumattomaksi
     */
    public void alustaKentta(){
        for(int rivi=0 ; rivi <= 9 ; rivi++ ){
            for(int sarake=0 ; sarake <= 9 ; sarake++ ){
                pelikentta[rivi][sarake]=-1;
            }
        }
    }
    
    /**
     * Tarkistetaan halutun ruudun tila ja palautetaan se
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     * 
     * @return ruudun tila
     */
    public int tarkista(int x, int y){
        return pelikentta[x][y];
    }
    
    /**
     *Muutetaan annetun ruudun tila hudiksi
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     */
    public void muutaOhi(int x, int y) {
        pelikentta[x][y]=0;
    }
    
    /**
     * Muutetaan annetun ruudun tila laivan sisältäväksi
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     */
    public void muutaLaivaksi(int x, int y){
        pelikentta[x][y]=2;
    }
    
    /**
     * Muutetaan annetun ruudun tila osumaksi
     * 
     * @param x käyttäjän antama syöte
     * @param y käyttäjän antama syöte
     */
    public void muutaOsui(int x, int y){
        pelikentta[x][y]=1;
    }
    
    /**
     * muutta ruudut, joihin laiva on asetettu, pelikentällä myöskin vastaamaan laivaa 
     * @param l  annettu laiva
     */
    public void asetaLaiva(Laiva l){
        if(l.getSuunta() == 0) {
            for(int i = 0; i < l.getKoko();i++){
                muutaLaivaksi(l.getX(), l.getY() +i);   
            }
        } else if(l.getSuunta() == 1){
            for(int i = 0; i < l.getKoko(); i++){
                muutaLaivaksi(l.getX() +i, l.getY());
            }
        }
    }
}

