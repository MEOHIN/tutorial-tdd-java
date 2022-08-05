public class SubDate {
    public static int getYearDay(int year) {
        if (year==1 ) return 0;
        else return 365;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }
}
