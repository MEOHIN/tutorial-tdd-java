public class SubDate {
    public static int getYearDay(int year) {
        int result = 0;
        for (int i = 1; i < year; i++) {
            if (isLeapYear(i)) result += 366;
            else result += 365;
        }
        return result;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

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
}
