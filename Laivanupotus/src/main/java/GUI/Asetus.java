
package GUI;
import Ohjelmalogiikka.Laivasto;
import Ohjelmalogiikka.Peli;
import Ohjelmalogiikka.Pelikentta;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Asetus extends JPanel{
    private Peli p;
    private Laivasto eka;
    private Laivasto toka;
    private Pelikentta ekan;
    private Pelikentta tokan;
    private CardLayout kortit;
    private JPanel korttiPaneeli;
    private JTextArea ekanAsetusTilanne;
    private JTextArea tokanAsetusTilanne;
    private AsetusRuudukko ekanRuudukko;
    private AsetusRuudukko tokanRuudukko;
//    
    public  Asetus(Peli p){
        super(new BorderLayout());
        this.p = p;
        this.eka = p.laivat1;
        this.toka = p.laivat2;
        this.ekan = p.kentta1;
        this.tokan = p.kentta2;
        this.ekanAsetusTilanne = new JTextArea("Pelaaja 1, aseta alukset!");
        this.tokanAsetusTilanne = new JTextArea("Pelaaja 2, aseteta alukset!");
        this.ekanRuudukko = new AsetusRuudukko(eka, tokan);
        this.tokanRuudukko = new AsetusRuudukko(toka, ekan);
        this.korttiPaneeli = new JPanel();
        this.kortit = new CardLayout();
        korttiPaneeli.setLayout(kortit);

        luoKomponentit();
    }
    private void luoKomponentit() {


        JPanel ylempiPaneeli = ylempiPaneeli();
        add(ylempiPaneeli, BorderLayout.CENTER);
        JButton valmis = new JButton("Valmis");
        valmisNapinKuuntelija kuuntelija = new valmisNapinKuuntelija(this);
        valmis.addActionListener(kuuntelija);
        add(valmis, BorderLayout.SOUTH);

    }
    private JPanel ylempiPaneeli() {

        JPanel ekanKortti = new JPanel();
        ekanKortti.setLayout(new BoxLayout(ekanKortti, BoxLayout.X_AXIS));

        JPanel tokanKortti = new JPanel();
        tokanKortti.setLayout(new BoxLayout(tokanKortti, BoxLayout.X_AXIS));

        ekanKortti.add(ekanRuudukko);
        ekanKortti.add(ekanAsetusTilanne);

        tokanKortti.add(tokanRuudukko);
        tokanKortti.add(tokanAsetusTilanne);

        korttiPaneeli.add(ekanKortti, "Eka");
        korttiPaneeli.add(tokanKortti, "Toka");
        return korttiPaneeli;
    }
    
    public class valmisNapinKuuntelija implements ActionListener {

        JPanel tama;

        public valmisNapinKuuntelija(JPanel tama) {
            this.tama = tama;

        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
           
            if (eka.onkoKaikkiAsetettu()&& toka.onkoKaikkiAsetettu()) {
                tama.setVisible(false); 
//                peli.paivitaTilanne();
//                peli.setVisible(true);
            } else if (eka.onkoKaikkiAsetettu()) {
                kortit.next(korttiPaneeli);
            }

        }

    }
}
