
package Ohjelmalogiikka;

public class Pelikentta {
    private int [][] pelikentta;

    public Pelikentta() {
        this.pelikentta = new int[10][10];
        alustaKentta();
    }
    
    public void alustaKentta(){
        for(int rivi=0 ; rivi < 10 ; rivi++ )
            for(int sarake=0 ; sarake < 10 ; sarake++ )
                pelikentta[rivi][sarake]=-1;
    }
    
    public int tarkista(int x, int y){
        return pelikentta[x][y];
    }
    
    public void muutaOhi(int x, int y) {
        pelikentta[x][y]=0;
    }
    
    public void muutaOsui(int x, int y){
        pelikentta[x][y]=1;
    }
    
}
