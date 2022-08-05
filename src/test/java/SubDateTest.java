import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

class SubDateTest extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(SubDateTest.class);
    }
    public void testGetYearDay(){
        assertEquals(0,SubDate.getYearDay(1));
        assertEquals(365,SubDate.getYearDay(2));
    }
}