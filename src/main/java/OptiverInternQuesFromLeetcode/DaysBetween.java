package OptiverInternQuesFromLeetcode;

public class DaysBetween {
    /**
     * Ques1.png
     */
    public static void main(String[] args) {
        System.out.println(daysBetween(2010, 5, 1,2011,5,1));
    }
    public static long daysBetween(int year1, int month1, int day1, int year2, int month2, int day2) {
        // first idea
        int dayDifferenceInYear = 0;
        for (int year = year1 + 1; year <= year2; year++) {
            dayDifferenceInYear += year % 4 == 0 ? 366 : 365;
        }
        return dayDifferenceInYear + monthToDay(month2) - monthToDay(month1) + day2 - day1;
    }
    public static long monthToDay(int month) {
        int monthToDay1 = 0;
        boolean is31 = true;
        for (int i = 1; i < month; i++) {
            if (is31) monthToDay1 += 31;
            else monthToDay1 += 30;
            if (i == 7) continue;
            is31 = !is31;
        }
        return monthToDay1;
    }
}
