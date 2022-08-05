public class SubDate {
    public static int getYearDay(int year) {
        if (year==1 ) return 0;
        else return 365;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }
}
