
package GUI;
import Ohjelmalogiikka.Laiva;
import Ohjelmalogiikka.Laivasto;
import Ohjelmalogiikka.Peli;
import Ohjelmalogiikka.Pelikentta;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Jonas
 */
public class AsetusRuudukko extends JPanel{
    private final int koko = 10;
    private Laivasto l;
    private Pelikentta p;
    private int laitettuja;
    private Selostaja s;

    /**
     * luodaan ruudukko joka koostuu koordinaattinapeista, joka asettaa laivaston
     * laivat käyttäjän haluamiin paikkoihin
     * 
     * @param l pelaavan pelaajan laivaston
     * @param p pelaaja, joka asettaa laivaston
     * @param s selostja, joka selostaa tätä peliä
     */
    public AsetusRuudukko(Laivasto l, Pelikentta p, Selostaja s) {
        this.l = l;
        this.p = p;
        this.s = s;
        this.laitettuja = 0;
        this.setLayout(new GridLayout(koko, koko));
        luoPainikkeet();
        
    }
    
    private void luoPainikkeet() {
        
        for (int j = 0; j < koko; j++) {
            
            
            for (int i = 0; i < koko; i++) {    
                
                JButton nappula = new JButton();
                nappula.setEnabled(true);

//                nappula.setBackground(Color.WHITE);
//                nappula.setEnabled(painettavissa);
                
                asetusKuuntelija kuuntelija = new asetusKuuntelija();
                nappula.addActionListener(kuuntelija);
                
                this.add(nappula);
            }
        }
    }
    
    /**
     * palauttaa koon
     * @return koko
     */
    public int getKoko() {
        return this.koko;
    }
    
    /**
     * tarkistaa voiko laivan laittaa tähän ja palauttaa selostajalle tapahtuman 
     * kulun. Jos voi asettaa laivan, muuten ei aseta ja palauttaa tiedon tästä
     * 
     * @param x x-koordinaatti johon laiva halutaan laittaa
     * @param y y-koordinaatti johon laiva halutaan laittaa
     * @param vaaka suunta johon laiva halutaan laittaa
     * 
     * @return teksti siitä mitä tehdään
     */
    public String AsetusRuudussa(int x, int y, int vaaka) {
        if(!l.onkoKaikkiAsetettu()){
            Laiva nyt = l.getLaivat().get(laitettuja);
            if(!l.onkoJoLaiva(x, y, nyt.getKoko(), vaaka)){
                if(nyt.sopiikoLaiva(x, y, vaaka)){
                    nyt.asetaLaiva(x, y, vaaka);
                    p.asetaLaiva(nyt);
                    laitettuja++;
                    s.asetettu();
                    return "Laiva asetettu";
                } else {
                    s.eiVoiAsettaa();
                    return "Laivaa ei voi asettaa tähän";
                }
            } else  {
                s.eiVoiAsettaa();
                return "Tässä on jo laiva";
            } 
        }
        s.kaikkiAsetettu();
        return "Olet jo asettanut kaikki laivat";
    }
    
    /**
     * kuuntelija, joka reagoi pelin tapahtumien mukaan
     */
    public class asetusKuuntelija implements ActionListener {
        private int vaaka;
        private JButton nappi;

        /**
         *
         */
        public asetusKuuntelija() {
         

        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            int vaaka;
            if ((ae.getModifiers() & InputEvent.SHIFT_MASK) != 0) {
                vaaka = 0;
            } else {
                vaaka = 1;
            }
            nappi = (JButton)ae.getSource();
            System.out.println("suunta " + vaaka+" x "+ nappi.getX()/34+" y "+ (nappi.getY()-4)/41);
            System.out.println(AsetusRuudussa(nappi.getX()/34, (nappi.getY()-4)/41, vaaka));
        }

    }
}
  
