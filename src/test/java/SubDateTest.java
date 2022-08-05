import junit.framework.TestCase;

/**
 * 두 개의 날짜 (YYYYMMDD) 의 일 수 차이를 구하는 프로그램을 TDD 로 작성한다.
 */
public class SubDateTest extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(SubDateTest.class);
    }

    /**
     * 전년도까지의 총 일수를 구한다.
     */
    public void testGetYearDay(){
        // 0년은 존재하지 않는다. 최소 일자는 1년 1월 1일이다. 따라서 1년까지의 총 일수는 0이 돼야한다.
        assertEquals(0,SubDate.getYearDay(1));
        // 2년까지의 총 일수는 1년 1월 1일부터 2년 1월 1일까지다. 따라서 365일이다.
        assertEquals(365,SubDate.getYearDay(2));
        /* 실패하는 코드다.
        * 5년 미만의 총 일수를 구한다.*/
        assertEquals(365+365+365+366, SubDate.getYearDay(5));
    }

    /**
     * 윤년을 확인한다.
     */
    public void testLeapYear() {
        assertTrue(SubDate.isLeapYear(0));
        assertFalse(SubDate.isLeapYear(1));
        assertTrue(SubDate.isLeapYear(4));
        assertTrue(SubDate.isLeapYear(1200));    // 윤년
        assertFalse(SubDate.isLeapYear(700));    // 평년
    }

    /**
     * 전월까지의 총 일수를 구한다.
     */
    public void testGetMonthDay() {
        assertEquals(0, SubDate.getMonthDay(1, true));
        assertEquals(31, SubDate.getMonthDay(2, false));
        assertEquals(31+28, SubDate.getMonthDay(3, false));
        assertEquals(31+29, SubDate.getMonthDay(3, true));
    }

    /**
     * 해당일자까지의 총 일수를 구한다.
     */
    public void testGetTotalDay() {
        assertEquals(1, SubDate.getTotalDay("00010101"));
        assertEquals(366, SubDate.getTotalDay("00020101"));
    }

    /**
     * 특정 일자의 총 일수를 구한다.
     */
    public void testSubDate() {
        assertEquals(1, SubDate.sub("20061231", "20070101"));
        assertEquals(31+28+30+31+14, SubDate.sub("20070101", "20070515"));
        assertEquals(31+29+30+31+14, SubDate.sub("20080101", "20080515"));
    }
}