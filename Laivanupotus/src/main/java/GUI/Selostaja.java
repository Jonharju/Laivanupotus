
package GUI;

import Ohjelmalogiikka.Peli;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Jonas
 */
public class Selostaja extends JPanel {
    private JTextArea vuoronKertoja;
    private Peli p;

    /**
     * luo uuden selostajan, joka tulostaa GUI:n tekstit, jotka halutaan näyttää pelaajille
     * @param p peli, jota GUI kuvaa ja selostaja selostaa
     */
    public Selostaja(Peli p) {
        super();
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.p = p;
        this.vuoronKertoja = new JTextArea("Ensimmäinen aloittaa");
        luoKomponentit();
    }
    private void luoKomponentit() {
        add(vuoronKertoja);
        vuoronKertoja.setEditable(false);
    }
    
    /**
     * kertoo pelaajille vuoron vaihtumisesta
     * @param pelaaja pelaaja, jonka vuoro on
     */
    public void vaihdaVuoroa(int pelaaja) {
        if(pelaaja == 1 ){
            vuoronKertoja.setText(p.nimi1 + " vuoro");
        } else if (pelaaja == 2){
            vuoronKertoja.setText(p.nimi2 + " vuoro");
        }
    }

    /**
     * ilmoittaa käyttäjälle osumasta
     */
    public void osuma() {
        vuoronKertoja.setText("Osuit Laivaan! Saat yrittää uudestaan");
    }
    
    /**
     * ilmoittaa käyttäjälle hudista
     */
    public void ohi() {
        vuoronKertoja.setText("Ammuit huti! Toisen pelaajan vuoro");
    }
    
    /**
     * ilmoittaa käyttäjälle, ettei ole hänen vuorons
     */
    public void eiSinunVuorosi() {
            vuoronKertoja.setText("Ei ole sinun vuorosi ampua!");
    }
    
    /**
     * ilmoittaa käyttäjän jo ampuneen siihen ruutuun
     */
    public void oletJoAmpunut() {
            vuoronKertoja.setText("Olet jo apunut tähän ruutuun!");
    }
    
    /**
     * ilmoittaa pelaajan voittaneen pelin
     */
    public void voitit() {
            vuoronKertoja.setText("Onneksi olkoon, voitit pelin!");
    }
    
    /**
     * ilmoittaa pelaajalle että laiva on asetettu
     */
    public void asetettu() {
        vuoronKertoja.setText("Laiva asetettu");
    }
    
    /**
     * ilmoittaa käyttäjälle että laivaa ei voi asetta siihen
     */
    public void eiVoiAsettaa() {
        vuoronKertoja.setText("Laivaa ei voi asettaa tähän");
    }
    
    /**
     * ilmoittaa käyttäjälle hänen jo asettaneen kaikki hänen laivansa
     */
    public void kaikkiAsetettu() {
        vuoronKertoja.setText("Olet asettanut kaikki laivat! Paina valmis nappia");
    }
}
