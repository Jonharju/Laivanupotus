package Ohjelmalogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelikenttaTest {
    
    public PelikenttaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void luoKentanOikein(){
        Pelikentta kentta = new Pelikentta();
        for(int i = 0; i<=9; i++){
            for(int j = 0; j <= 9; j++) {
                assertEquals(-1, kentta.tarkista(i, j));
            }
        }
    }
    
    @Test
    public void muuttaaOhi(){
        Pelikentta kentta = new Pelikentta();
        kentta.muutaOhi(1, 1);
        assertEquals(0, kentta.tarkista(1, 1));
    }
    
    @Test
    public void muuttaaOsui(){
        Pelikentta kentta = new Pelikentta();
        kentta.muutaOsui(1, 1);
        assertEquals(1, kentta.tarkista(1, 1));
    }
    
    @Test
    public void muuttaaLaivaksi(){
        Pelikentta kentta = new Pelikentta();
        kentta.muutaLaivaksi(1, 1);
        assertEquals(2, kentta.tarkista(1, 1));
    }
    
    @Test
    public void alustaaKentanOikein(){
        Pelikentta kentta = new Pelikentta();
        for(int i = 0; i<=9; i++){
            for(int j = 0; j <= 9; j++) {
                assertEquals(-1, kentta.tarkista(i, j));
            }
        }
        kentta.muutaOhi(1, 1);
        assertEquals(0, kentta.tarkista(1, 1));
        kentta.muutaOsui(2, 2);
        assertEquals(1, kentta.tarkista(2, 2));
        kentta.alustaKentta();
        assertEquals(-1, kentta.tarkista(1, 1));
        assertEquals(-1, kentta.tarkista(2, 2));
    }
    @Test
    public void alustaaLaivanOikein(){
        Pelikentta kentta = new Pelikentta();
        Laiva l = new Laiva(3);
        l.asetaLaiva(1, 1, 1);
        kentta.asetaLaiva(l);
        assertEquals(2, kentta.tarkista(1, 1));
        assertEquals(2, kentta.tarkista(2, 1));
        assertEquals(2, kentta.tarkista(3, 1));
    }
}
