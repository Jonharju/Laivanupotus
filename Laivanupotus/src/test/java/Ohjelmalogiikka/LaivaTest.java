
package Ohjelmalogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaivaTest {
    
    public LaivaTest() {
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
    public void luoLaivanOikein(){
        Laiva laiva = new Laiva(3);
        assertEquals(false, laiva.uponnut());
    }
    
    @Test
    public void osuuLaivaan(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 1);
        assertEquals(true, laiva.osuiko(1, 1));
    }
    
    @Test
    public void uppoaa(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 1);
        assertEquals(true, laiva.osuiko(1, 1));
        assertEquals(true, laiva.osuiko(2, 1));
        assertEquals(true, laiva.osuiko(3, 1));
        assertEquals(true, laiva.uponnut());
    }
     @Test
    public void osuuUseammankerran(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 1);
        assertEquals(true, laiva.osuiko(1, 1));
        assertEquals(true, laiva.osuiko(2, 1));
    }
    @Test
    public void eiUppoaLiianVahasta(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 1);
        assertEquals(true, laiva.osuiko(1, 1));
        assertEquals(true, laiva.osuiko(2, 1));
        assertEquals(false, laiva.uponnut());
    }
    
    @Test
    public void ohiEiOsu(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 1);
        assertEquals(false, laiva.osuiko(1, 2));
    }
    
    @Test
    public void mahtuukoLaivaEi(){
        Laiva laiva = new Laiva(3);
        assertEquals(false, laiva.sopiikoLaiva(8, 8,1));
    }
    
    @Test
    public void mahtuukoLaivaKylla(){
        Laiva laiva = new Laiva(3);
        assertEquals(true, laiva.sopiikoLaiva(7, 7,1));
    }
    
    @Test
    public void eiOsuLiikaa(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 1);
        assertEquals(true, laiva.osuiko(1, 1));
        assertEquals(true, laiva.osuiko(2, 1));
        assertEquals(true, laiva.osuiko(3, 1));
        assertEquals(true, laiva.uponnut());
        laiva.osu();
        assertEquals(3, laiva.osumia);
    }
    
    @Test
    public void onkoLaivaPaikallaan(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 1);
        assertEquals(true, laiva.onkoLaivaTassa(1, 1));
        assertEquals(true, laiva.onkoLaivaTassa(2, 1));
        assertEquals(true, laiva.onkoLaivaTassa(3, 1));
    }
    
    @Test
    public void eiOleLaivaPaikallaan(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 1);
        assertEquals(false, laiva.onkoLaivaTassa(1, 4));
        assertEquals(false, laiva.onkoLaivaTassa(4, 1));
        assertEquals(false, laiva.onkoLaivaTassa(3, 3));
    }
}
