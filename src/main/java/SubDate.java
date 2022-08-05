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
}
