import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

class SubDateTest extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(SubDateTest.class);
    }

    public void testGetYearDay(){
        // 0년은 존재하지 않는다. 최소 일자는 1년 1월 1일이다. 따라서 1년까지의 총 일수는 0이 돼야한다.
        assertEquals(0,SubDate.getYearDay(1));
        // 2년까지의 총 일수는 1년 1월 1일부터 2년 1월 1일까지다. 따라서 365일이다.
        assertEquals(365,SubDate.getYearDay(2));
        /* 실패하는 코드다.
        * 5년 미만의 총 일수를 구한다.*/
//        assertEquals(365+365+365+366, SubDate.getYearDay(5));
    }

    public void testLeapYear() {
        assertTrue(SubDate.isLeapYear(0));
        assertFalse(SubDate.isLeapYear(1));
        assertTrue(SubDate.isLeapYear(4));
    }
}