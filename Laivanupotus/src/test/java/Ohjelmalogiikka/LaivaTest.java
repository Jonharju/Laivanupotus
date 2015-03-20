
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
        laiva.asetaLaiva(1, 1, 'v');
        assertEquals(true, laiva.osuiko(1, 1));
    }
    
    @Test
    public void uppoaa(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 'v');
        assertEquals(true, laiva.osuiko(1, 1));
        assertEquals(true, laiva.osuiko(1, 2));
        assertEquals(true, laiva.osuiko(1, 3));
        assertEquals(true, laiva.uponnut());
    }
    
    @Test
    public void eiUppoaLiianVahasta(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 'v');
        assertEquals(true, laiva.osuiko(1, 1));
        assertEquals(true, laiva.osuiko(1, 2));
        assertEquals(false, laiva.uponnut());
    }
    
    @Test
    public void ohiEiOsu(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 'v');
        assertEquals(false, laiva.osuiko(2, 1));
    }
    
    @Test
    public void tyhjaaOsumat(){
        Laiva laiva = new Laiva(3);
        laiva.asetaLaiva(1, 1, 'v');
        assertEquals(true, laiva.osuiko(1, 1));
        assertEquals(true, laiva.osuiko(1, 2));
        assertEquals(true, laiva.osuiko(1, 3));
        assertEquals(true, laiva.uponnut());
        laiva.tyhjaaOsumat();
        assertEquals(false, laiva.uponnut());
    }
}
