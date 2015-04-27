
package GUI;


import Ohjelmalogiikka.Peli;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GraafinenKayttoLiittyma implements Runnable{
    private JFrame frame;
    private Peli p;
    private Alku aloitus;
    private Asetus asetus;
    private Ampuminen ampuminen;

    public GraafinenKayttoLiittyma(Peli p) {
        this.p = p;
        this.ampuminen = new Ampuminen(p);
        this.asetus = new Asetus(p, ampuminen);
        this.aloitus = new Alku(p, asetus);
                
    }
    @Override
    public void run() {
        frame = new JFrame("Laivanupotus");
        frame.setPreferredSize(new Dimension(1200, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(aloitus);
        asetus.setVisible(false);
        container.add(asetus);
        ampuminen.setVisible(false);
        container.add(ampuminen);
    }
    
    public JFrame getFrame() {
        return frame;
    }
   
}
