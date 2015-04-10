
package Ohjelmalogiikka;

public class Laiva {
    int x;
    int y;
    int suunta;
    int koko;
    int osumia;

    public Laiva(int koko) {
        this.x = -1;
        this.y = -1;
        this.suunta = -1;
        this.koko = koko;
        this.osumia = 0;
    }
//    0 merkkaa pystyyn, 1 vaakaan
    public void asetaLaiva(int x, int y, int suunta){
        this.x = x;
        this.y = y;
        this.suunta = suunta;
    }
//    tarkistetaan onko lähtöruutu ulkopuolella, sitten mahtuuko kentälle
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
    public void osu(){
        if(this.osumia < this.koko){
            this.osumia++;
        }
    }
    public boolean osuiko(int x, int y) {
        if(onkoLaivaTassa(x, y)){
            osu();
            return true;
        }
        return false;
    }
    
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
    
    public boolean uponnut(){
       return this.osumia == this.koko;
    }
    
}
