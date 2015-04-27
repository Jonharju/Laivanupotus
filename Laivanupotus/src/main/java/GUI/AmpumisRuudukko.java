
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

    public AmpumisRuudukko(Peli peli, Laivasto l, Pelikentta p, int pelaaja) {
        this.peli = peli;
        this.l = l;
        this.p = p;
        this.pelaaja = pelaaja;
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
                        if(l.onkoKaikkiUponnut()){
                            System.out.println("voitit pelin!");
                        }
                    }  
                } else if(p.tarkista(nappi.getX(), nappi.getY()) == -1){
                    System.out.println("Ammuit huti");
                    p.muutaOhi(nappi.getX(), nappi.getY());
                    nappi.setBackground(Color.BLUE);
                    peli.vaihdaVuoro();
                } else {
                    System.out.println("Olet jo ampunut tähän ruutuun");
                }
            } else {
                System.out.println("Ei ole sinun vuorosi!");
            }
        }

    }
    
    //    public void varitaNappulat() {
//        Pelilauta pelilauta = kayttaja.getPelilauta();
//        
//        for (int j = 0; j < koko; j++) {
//            for (int i = 0; i < koko; i++) {
//                Ruutu ruutu = pelilauta.haeRuutu(new Sijainti(i, j));
//                
//                JButton nappula = haeNappula(ruutu.getSijainti());
//                
//                char merkki = haeMerkki(ruutu.getSijainti());
//                varita(nappula, merkki);
//            }
//        }
//    }
//        
//    private void varita(JButton nappula, int merkki) {
//        
//        if (merkki == '-1' || merkki == '2') {
//            nappula.setBackground(Color.WHITE);
//        }
//        else if (merkki == '0') {
//            nappula.setBackground(Color.BLUE);
//        }
//        else if (merkki == '3') {
//            nappula.setBackground(Color.CYAN);
//        }
//        else if (merkki == '1') {
//            nappula.setBackground(Color.RED);
//        }
//        else {  // merkki == '4'
//            nappula.setBackground(Color.BLACK);
//        }
//    }
//    
//    private char haeMerkki(Sijainti sijainti) {
//        PelilaudanPiirtaja piirtaja = new PelilaudanPiirtaja(kayttaja);
//        return piirtaja.palautaSeuraavaMerkki(sijainti);
//    }
//    
//    private JButton haeNappula(Sijainti sijainti) {
//        JPanel rivi = (JPanel) this.getComponent(sijainti.getY());
//        return (JButton) rivi.getComponent(sijainti.getX());
//    }
//    
//    public void varitaRuutu(String sijaintiKentta) {
//        Sijainti sijainti = new SijainninMaarittaja().maaritaSijainti(sijaintiKentta);
//        varitaNappulat();
//        varitaRuutu(sijainti);
//    }
//    
//    private void varitaRuutu(Sijainti sijainti) {
//        JButton nappula = haeNappula(sijainti);
//        
//        if (nappula.getBackground() == Color.WHITE) {
//            nappula.setBackground(Color.PINK);    
//        }
//    }
//    
//    public void laivanAsettaminen(String sijaintiKentta, String suuntaKentta) {
//        Laiva laiva = maaritaLaiva(sijaintiKentta, suuntaKentta, kayttaja.getPelilauta().getLaivat().size());
//        varitaRuudut(laiva);
//    }
//    
//    public Laiva maaritaLaiva(String sijaintiKenttaText, String suuntaKenttaText, int laivoja) {
//        int laivanKoko = new LaivanKoonMaarittaja().maaritaKoko(laivoja);
//        Sijainti sijainti = new SijainninMaarittaja().maaritaSijainti(sijaintiKenttaText);
//        Suunta suunta = Suunta.ALAS;
//        
//        if (suuntaKenttaText.equals("OIKEALLE")) {
//            suunta = Suunta.OIKEALLE;
//        }
//        
//        return new Laiva(sijainti, suunta, laivanKoko);
//    }
//    
//    private void varitaRuudut(Laiva laiva) {
//        varitaNappulat();
//        
//        if (kayttaja.getPelilauta().voidaankoAsettaa(laiva)) {
//        
//            for (int i = 0; i < laiva.getKoko(); i++) {
//                Sijainti sijainti = laiva.haeLaivanOsanSijainti(i);
//                varitaRuutu(sijainti);
//            }
//        }
//    }
    
}
