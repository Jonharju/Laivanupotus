
package GUI;
import Ohjelmalogiikka.Peli;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Alku extends JPanel implements ActionListener {
    private Peli p;
    private String nimi1;
    private String nimi2;
    private boolean eka;
    private boolean toka;
    private JButton aseta1;
    private JButton aseta2;
    private JTextField nimiRuutu1;
    private JTextField nimiRuutu2;
    
    
    public Alku(Peli p) {
        super(new GridLayout(3, 2));
        this.p = p;
        this.eka = false;
        this.toka = false;
        this.aseta1 = new JButton("Pelaaja 1 valmis!");
        this.aseta2 = new JButton("Pelaaja 2 valmis!");
        luoKomponentit();

    }
    private void luoKomponentit() {

        JLabel nimiTeksti1 = new JLabel("Pelaaja 1: ");
        nimiRuutu1 = new JTextField();

        JLabel nimiTeksti2 = new JLabel("Pelaaja 2: ");
        nimiRuutu2 = new JTextField();

        aseta1.addActionListener(this);
        aseta2.addActionListener(this);

        add(nimiTeksti1);
        add(nimiTeksti2);
        add(nimiRuutu1);
        add(nimiRuutu2);
        add(aseta1);
        add(aseta2);
    }

    @Override
    public void actionPerformed(ActionEvent event) {          
        
        if (event.getSource() == aseta1) {
            eka = true;
            nimi1 = nimiRuutu1.getText();
            p.nimi1 = nimi1;
        }
        if(event.getSource() == aseta2){
            toka = true;
            nimi2 = nimiRuutu2.getText();
            p.nimi2 = nimi2;
        }
        
        if(eka&&toka){
            this.setVisible(false);
//            Asetus.setVisible(true);
//            Asetus.repaint();
        }
    }
}
    
