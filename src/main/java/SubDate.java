/**
 * 두 개의 날짜 (YYYYMMDD) 의 일 수 차이를 구하는 프로그램이다.
 * TDD 로 작성된 test 를 통과하기 위해 작성한다.
 */
public class SubDate {
    /**
     * 전년도까지의 총 일수를 구한다.
     * @param year 연도
     * @return 전년도까지의 총 일수
     */
    public static int getYearDay(int year) {
        int result = 0;
        for (int i = 1; i < year; i++) {
            if (isLeapYear(i)) result += 366;
            else result += 365;
        }
        return result;
    }

    /**
     * 윤년을 확인한다.
     * @param year 연도
     * @return 입력받은 연도가 윤년이면 true, 아니면 false
     */
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    /**
     * 전월까지의 총 일수를 구한다.
     */
    static final int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int getMonthDay(int month, boolean isLeap) {
        int result = 0;
        for (int i = 1; i < month; i++) {
            result += monthDays[i-1];
        }

        if (isLeap && month > 2) {
            result += 1;
        }
        return result;
    }

    /**
     * 해당일자까지의 총 일수를 구한다.
     * @param date 날짜(YYYYMMDD)
     * @return 입력받은 일자까지의 총 일수
     */
    public static int getTotalDay(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));

        return getYearDay(year) + getMonthDay(month, isLeapYear(year)) + day;
    }

    /**
     * 특정 일자의 총 일수를 구한다.
     * @param date1 날짜1
     * @param date2 날짜2
     * @return 날짜1 - 날짜2
     */
    public static int sub(String date1, String date2) {
        return Math.abs(getTotalDay(date1) - getTotalDay(date2));
    }
}
