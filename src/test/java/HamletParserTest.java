import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
       hamletParser.replaceWord("[hH][aA][mM][lL][eE][tT]",hamletText,"Leon");
       System.out.println(hamletParser.getHamletData());
       int actual = hamletParser.findOccurrencesOfWord("[hH][aA][mM][lL][eE][tT]",hamletParser.getHamletData());
       assertFalse(hamletParser.findIfWordOccurs("Hamlet",hamletParser.getHamletData()));
       assertEquals(0,actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.replaceWord("[hH][oO][rR][aA][tT][iI][oO]",hamletText,"Tariq");
        System.out.println(hamletParser.getHamletData());
        int actual = hamletParser.findOccurrencesOfWord("[hH][oO][rR][aA][tT][iI][oO]",hamletParser.getHamletData());
        assertFalse(hamletParser.findIfWordOccurs("Horatio",hamletParser.getHamletData()));
        assertEquals(0,actual);
    }

    @Test
    public void testFindHoratio() {
        assertTrue(hamletParser.findIfWordOccurs("Horatio",hamletText));
    }

    @Test
    public void testFindHamlet() {
        assertTrue(hamletParser.findIfWordOccurs("Hamlet",hamletText));
    }

}