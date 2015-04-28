
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

public class AsetusRuudukko extends JPanel{
    private final int koko = 10;
    private Laivasto l;
    private Pelikentta p;
    private int laitettuja;
    private Selostaja s;

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
            
            JPanel rivi = new JPanel(new GridLayout(1, koko));
            
            for (int i = 0; i < koko; i++) {    
                
                KoordinaattiNappi nappula = new KoordinaattiNappi(i,j);
                nappula.setEnabled(true);

//                nappula.setBackground(Color.WHITE);
//                nappula.setEnabled(painettavissa);
                
                asetusKuuntelija kuuntelija = new asetusKuuntelija();
                nappula.addActionListener(kuuntelija);
                
                rivi.add(nappula);
            }
            this.add(rivi);
        }
    }
    
    
    public int getKoko() {
        return this.koko;
    }
    
    public String AsetusRuudussa(int x, int y, int vaaka) {
        if(!l.onkoKaikkiAsetettu()){
            Laiva nyt = l.laivat.get(laitettuja);
            if(!l.onkoJoLaiva(x, y, nyt.getKoko(), vaaka)){
                if(nyt.sopiikoLaiva(x, y, vaaka)){
                    nyt.asetaLaiva(x, y, vaaka);
                    p.asetaLaiva(nyt);
                    laitettuja++;
                    s.asetettu();
                    return "Laiva asetettu";
                } 
            } else {
                s.eiVoiAsettaa();
                return "Laivaa ei voi asettaa tähän";
            } 
        }
        s.kaikkiAsetettu();
        return "Olet jo asettanut kaikki laivat";
    }
    
    public class asetusKuuntelija implements ActionListener {
        private int vaaka;
        private KoordinaattiNappi nappi;

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
            nappi = (KoordinaattiNappi)ae.getSource();
            System.out.println("suunta " + vaaka+" x "+ nappi.getX()+" y "+ nappi.getY());
            System.out.println(AsetusRuudussa(nappi.getX(), nappi.getY(), vaaka));
        }

    }
}
  
