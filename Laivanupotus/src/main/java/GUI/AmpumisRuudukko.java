
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


public class AmpumisRuudukko extends JPanel{
    private final int koko = 10;
    private Laivasto l;
    private Pelikentta p;
    private Peli peli;
    private int pelaaja;
    private Selostaja s;

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
            
            JPanel rivi = new JPanel(new GridLayout(1, koko));
            
            for (int i = 0; i < koko; i++) {    
                
                KoordinaattiNappi nappula = new KoordinaattiNappi(i,j);
                nappula.setEnabled(true);

                ampumisKuuntelija kuuntelija = new ampumisKuuntelija(nappula);
                nappula.addActionListener(kuuntelija);
                
                rivi.add(nappula);
            }
            this.add(rivi);
        }
    }
    
    
    public int getKoko() {
        return this.koko;
    }
    
    public class ampumisKuuntelija implements ActionListener {

        private KoordinaattiNappi nappi;

        public ampumisKuuntelija(KoordinaattiNappi nappi) {
            this.nappi = nappi;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(pelaaja == peli.kummanVuoro()){
                if(p.tarkista(nappi.getX(), nappi.getY()) == 2){  
                    if(l.osuiko(nappi.getX(), nappi.getY())){
                        p.muutaOsui(nappi.getX(), nappi.getY());
                        nappi.setBackground(Color.RED);
                        s.osuma();
                        if(l.onkoKaikkiUponnut()){
                            System.out.println("voitit pelin!");
                            s.voitit();
                        }
                    }  
                } else if(p.tarkista(nappi.getX(), nappi.getY()) == -1){
                    System.out.println("Ammuit huti");
                    s.ohi();
                    p.muutaOhi(nappi.getX(), nappi.getY());
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