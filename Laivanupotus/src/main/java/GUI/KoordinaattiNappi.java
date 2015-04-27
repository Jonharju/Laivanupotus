
package GUI;

//import java.awt.Insets;
import javax.swing.JButton;

public class KoordinaattiNappi extends JButton{
    private int x;
    private int y;

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
