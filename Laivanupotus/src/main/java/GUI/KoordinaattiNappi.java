
package GUI;

//import java.awt.Insets;
import javax.swing.JButton;

/**
 *
 * @author Jonas
 */
public class KoordinaattiNappi extends JButton{
    private int x;
    private int y;

    /**
     * luo uuden napin, joka tietää omat koordinaattinsa
     * @param x napin x koordinaatti
     * @param y napin y koordinaatti
     */
    public KoordinaattiNappi(int x, int y) {
        this.x = x;
        this.y = y;
//        setMargin(new Insets(0,0,0,0));
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
}
