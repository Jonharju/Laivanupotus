
package Ohjelmalogiikka;

public class Laiva {
    int [][] koordinaatit;
    int koko;
    boolean [] osumat;

    public Laiva(int koko) {
        this.koko = koko;
        this.koordinaatit = new int[koko][2];
        this.osumat = new boolean[koko];
        tyhjaaOsumat();
    }
//    kirjain merkkaa laitetaanko laiva vaakaan vai pystyyn
    public void asetaLaiva(int x, int y, char s){
        if(s == 'v') {
            for(int i = 0; i < koko; i++) {
                koordinaatit[i][0] = x;
            }
            for(int j = 0; j<koko; j++){
                koordinaatit[j][1] = y+j;
            }
        } else if (s == 'p') {
            for(int i = 0; i < koko; i++) {
                koordinaatit[i][0] = x+1;
            }
            for(int j = 0; j<koko; j++){
                koordinaatit[j][1] = y;
            }
        }
    }
    public void tyhjaaOsumat (){
        for(int i = 0; i < koko; i++) {
            osumat[i] = false;
        }
    }
    
    public boolean osuiko(int x, int y) {
        for(int i = 0; i < koko; i++){
            if(x == koordinaatit[i][0]){
                if(y== koordinaatit[i][1]){
                    osumat[i] = true;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean uponnut(){
       for(int i = 0; i < koko; i++){
           if (osumat[i] == false){
               return false;
           }
       }
       return true;
    }
    
}
