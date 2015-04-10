
package Ohjelmalogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LaivastoTest {
    
    public LaivastoTest() {
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
    public void luoLaivat(){
        Laivasto l = new Laivasto();
        assertEquals(6, l.laivat.size());
    }
    
    @Test
    public void luodutLaivatJaljella(){
        Laivasto l = new Laivasto();
        assertEquals(false, l.onkoKaikkiUponnut());
    }
    
    @Test
    public void upottaaLaivat(){
        Laivasto l = new Laivasto();
        for(Laiva laiva: l.laivat){
            for(int i = 0; i<laiva.koko; i++){
                laiva.osu();
            }
        }
        assertEquals(true, l.onkoKaikkiUponnut());
    }
    
    @Test
    public void osuuLaivoihin(){
        Laivasto l = new Laivasto();
        int i = 1;
        for(Laiva laiva: l.laivat){
            laiva.asetaLaiva(i, i, 1);
            i++;
        }
        assertEquals(true, l.onkoJoLaiva(1, 1));
        assertEquals(true, l.onkoJoLaiva(2, 2));
    }
}
