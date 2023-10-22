package cm;

public class Period
{
    private int startHour;
    private int endHour;
    public Period(int start, int end)
    {

    }
    public int duration()
    {
        // the duration method returns the duration of stay in hours.
        return 0;
    }
    public Boolean overlaps(Period period)
    {
        // the overlaps method returns true if the passed 'Period' overlaps the current 'Period'.
        return true;
    }
}
