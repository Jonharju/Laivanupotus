package Main;


import Ohjelmalogiikka.Laiva;
import Ohjelmalogiikka.Peli;
import Ohjelmalogiikka.Laivasto;
import GUI.GraafinenKayttoLiittyma;
import javax.swing.SwingUtilities;


public class Main {
    public static void main(String[] args){
        Peli p = new Peli();
        GraafinenKayttoLiittyma g = new GraafinenKayttoLiittyma(p);
        SwingUtilities.invokeLater(g);
    }
}
