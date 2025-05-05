public class APCalendar
{
  /** Returns true if year is a leap year and false otherwise. */
  private static boolean isLeapYear(int year)
  {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
  }


  /** Returns the number of leap years between year1 and year2, inclusive.
   * Precondition: 0 <= year1 <= year2
   */
  public static int numberOfLeapYears(int year1, int year2)
  { 
    /* to be implemented in part (a) */
    int leapYears = 0;

    for(int y = year1; y <= year2; y++)
        if(isLeapYear(y))
            leapYears++;

    return leapYears;
  }
  
  /** Returns the value representing the day of the week for the first day of year,
   *  where 0 denotes Sunday, 1 denotes Monday, ..., and 6 denotes Saturday.
   */
  private static int firstDayOfYear(int year)
  {
    /* January 1, 1980 was a Tuesday */
      return (2 + 365*(year - 1980) + numberOfLeapYears(1980, year-1)) % 7;
  }

  /** Returns n, where month, day, and year specify the nth day of the year.
   *  Returns 1 for January 1 (month = 1, day = 1) of any year.
   *  Precondition: The date represented by month, day, year is a valid date.
   */
  private static int dayOfYear(int month, int day, int year)
  {
    final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int n = day;
    int mth  = 1;
    while (mth < month)
    {
      n += daysInMonth[mth - 1];
      mth++;
    }
    if (mth > 2 && isLeapYear(year))
      n++;
    return n;
  }
  
  /** Returns the value representing the day of the week for the given date
   *  (month, day, year), where 0 denotes Sunday, 1 denotes Monday, ...,
   *  and 6 denotes Saturday.
   *  Precondition: The date represented by month, day, year is a valid date.
   */
  public static int dayOfWeek(int month, int day, int year)
  {
    /* to be implemented in part (b) */
    int weekday = firstDayOfYear(year);
    int additionalDays = dayOfYear(month, day, year) - 1;

    for(int d = 1; d <= additionalDays; d++)
    {
        weekday++;

        if(weekday == 7)
            weekday = 0;
    }

    return weekday;
  }
}
