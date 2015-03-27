
package Ohjelmalogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PeliTest {
    
    public PeliTest() {
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
    public void luoVuoron(){
        Peli p = new Peli();
        assertEquals(1, p.vuoro);
    }
    @Test
    public void kasvattaaVuoron(){
        Peli p = new Peli();
        p.vaihdaVuoro();
        assertEquals(2, p.vuoro);
    }
    @Test
    public void luoVuoronEkalle(){
        Peli p = new Peli();
        assertEquals(1, p.kummanVuoro());
    }
    @Test
    public void kasvattaaVuoronTokalle(){
        Peli p = new Peli();
        p.vaihdaVuoro();
        assertEquals(2, p.kummanVuoro());
    }
}
