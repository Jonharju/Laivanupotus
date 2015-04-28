
package GUI;

import Ohjelmalogiikka.Peli;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Selostaja extends JPanel {
    private JTextArea vuoronKertoja;
    private Peli p;

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
    
    public void vaihdaVuoroa(int pelaaja) {
        if(pelaaja == 1 ){
            vuoronKertoja.setText(p.nimi1 + " vuoro");
        } else if (pelaaja == 2){
            vuoronKertoja.setText(p.nimi2 + " vuoro");
        }
    }


    public void osuma() {
        vuoronKertoja.setText("Osuit Laivaan! Saat yrittää uudestaan");
    }
    
    public void ohi() {
        vuoronKertoja.setText("Ammuit huti! Toisen pelaajan vuoro");
    }
    
    public void eiSinunVuorosi() {
            vuoronKertoja.setText("Ei ole sinun vuorosi ampua!");
    }
    
    public void oletJoAmpunut() {
            vuoronKertoja.setText("Olet jo apunut tähän ruutuun!");
    }
    
    public void voitit() {
            vuoronKertoja.setText("Onneksi olkoon, voitit pelin!");
    }
    
    public void asetettu() {
        vuoronKertoja.setText("Laiva asetettu");
    }
    
    public void eiVoiAsettaa() {
        vuoronKertoja.setText("Laivaa ei voi asettaa tähän");
    }
    
    public void kaikkiAsetettu() {
        vuoronKertoja.setText("Olet asettanut kaikki laivat! Paina valmis nappia");
    }
}
