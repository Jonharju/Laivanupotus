
package GUI;
import Ohjelmalogiikka.Laivasto;
import Ohjelmalogiikka.Peli;
import Ohjelmalogiikka.Pelikentta;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.prism.j2d.J2DPipeline;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Ampuminen extends JPanel{
    private Peli p;
    private Laivasto eka;
    private Laivasto toka;
    private Pelikentta ekan;
    private Pelikentta tokan;
    private AmpumisRuudukko ekanRuudukko;
    private AmpumisRuudukko tokanRuudukko;
    private JTextArea teksti;

    public Ampuminen(Peli p) {
        super();
        super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.p = p;
        this.eka = p.laivat1;
        this.toka = p.laivat2;
        this.ekan = p.kentta1;
        this.tokan = p.kentta2;
        this.ekanRuudukko = new AmpumisRuudukko(p,eka, ekan, 1);
        this.tokanRuudukko = new AmpumisRuudukko(p,toka, tokan, 2);
        this.teksti = new JTextArea("Tänne tulee tekstiä");
        luoKomponentit();
    }
    
    private void luoKomponentit() {
        add(ekanRuudukko);
        add(teksti);
        add(tokanRuudukko);
    }
}
