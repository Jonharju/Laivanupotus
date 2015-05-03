
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
public class AmpumisRuudukko extends JPanel{
    private final int koko = 10;
    private Laivasto l;
    private Pelikentta p;
    private Peli peli;
    private int pelaaja;
    private Selostaja s;

    /**
     * luodaan uusi ampumisruudukko, joka koostuu koordinaattinappeista, joita 
     * pelaaja klickaa kun haluaa ampua jotain tiettyä ruutua
     * 
     * @param peli peli joka on käynnissä
     * @param l laivasto, joka sijaitsee tällä kentällä
     * @param p kenttä, johon pelaaja ampuu
     * @param pelaaja pelaaja, joka ampuu
     * @param s selostaja, joka kuvaa kyseistä peliä
     */
    public AmpumisRuudukko(Peli peli, Laivasto l, Pelikentta p, int pelaaja, Selostaja s) {
        this.peli = peli;
        this.l = l;
        this.p = p;
        this.pelaaja = pelaaja;
        this.s = s;
        this.setLayout(new GridLayout(koko, koko));
        luoPainikkeet();
    }
    
    private void luoPainikkeet() {
        
        for (int j = 0; j < koko; j++) {
            
            for (int i = 0; i < koko; i++) {    
                
                JButton nappula = new JButton();
                nappula.setEnabled(true);

                ampumisKuuntelija kuuntelija = new ampumisKuuntelija(nappula);
                nappula.addActionListener(kuuntelija);
                
                this.add(nappula);
            }
        }
    }
    
    /**
     * palauta kentän koko
     * @return koko
     */
    public int getKoko() {
        return this.koko;
    }
    
    /**
     * metodi joka reagoi pelin tapahtumiin niiden mukaisesti
     */
    public class ampumisKuuntelija implements ActionListener {

        private JButton nappi;

        /**
         *
         * @param nappi
         */
        public ampumisKuuntelija(JButton nappi) {
            this.nappi = nappi;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            int x = nappi.getX()/34;
            int y = (nappi.getY()-2)/44;
            System.out.println(nappi.getX()/34+ " " + (nappi.getY()-2)/44);
            if(pelaaja == peli.kummanVuoro()){
                if(p.tarkista(x, y) == 2){  
                    if(l.osuiko(x,y)){
                        p.muutaOsui(x,y);
                        nappi.setBackground(Color.RED);
                        s.osuma();
                        nappi.setEnabled(false);
                        if(l.onkoKaikkiUponnut()){
                            System.out.println("voitit pelin!");
                            s.voitit();
                        }
                    }  
                } else if(p.tarkista(x,y) == -1){
                    System.out.println("Ammuit huti");
                    s.ohi();
                    p.muutaOhi(x,y);
                    nappi.setBackground(Color.BLUE);
                    peli.vaihdaVuoro();
                } else {
                    System.out.println("Olet jo ampunut tähän ruutuun");
                    s.oletJoAmpunut();
                }
            } else {
                System.out.println("Ei ole sinun vuorosi!");
                s.eiSinunVuorosi();
            }
        }

    }
}