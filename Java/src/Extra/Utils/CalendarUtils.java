package src.Extra.Utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CalendarUtils {

    public static List<Integer> getCalenderYearWeekList(long start, long end) {

        List<Integer> yearWeeks;

        int[] startYearWeek = getYearWeek(start * 1000);
        int[] endYearWeek = getYearWeek(end * 1000);

        if (startYearWeek[0] == endYearWeek[0])
            yearWeeks = IntStream.rangeClosed(startYearWeek[1], endYearWeek[1]).boxed().collect(Collectors.toList());
        else {
            List<Integer> startList, endList;// = new ArrayList();
            int startYearEndWeek = getYearBoundaryWeek(true, startYearWeek[0]);
            startList = IntStream.rangeClosed(startYearWeek[1], startYearEndWeek).boxed().collect(Collectors.toList());

            int endYearFirstWeek = getYearBoundaryWeek(false, endYearWeek[0]);
            endList = IntStream.rangeClosed(endYearFirstWeek, endYearWeek[1]).boxed().collect(Collectors.toList());

            yearWeeks = Stream.concat(startList.stream(), endList.stream()).collect(Collectors.toList());
        }

        return yearWeeks;
    }

    private static int[] getYearWeek(Long timestamp) {

        Calendar thisCalenderObj = Calendar.getInstance();

        Date startDateObj = new Date(timestamp);
        thisCalenderObj.setTime(startDateObj);
        int thisYear = thisCalenderObj.get(Calendar.YEAR);
        int thisYearWeek = thisYear * 100 + getWeekFromCalendar(thisCalenderObj);

        return new int[]{thisYear, thisYearWeek};

    }

    private static int getYearBoundaryWeek(Boolean isStart, int year) {

        Calendar thisCalenderObj = Calendar.getInstance();
        int month = isStart ? Calendar.DECEMBER : Calendar.JANUARY;
        int date = isStart ? 31 : 1;

        thisCalenderObj.set(year, month, date);

        return year * 100 + getWeekFromCalendar(thisCalenderObj);
    }

    public static int getWeekFromCalendar(Calendar calendar) {
        int thisWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        if (calendar.get(Calendar.MONTH) == Calendar.DECEMBER && thisWeek == 1)
            thisWeek = 53;
        return thisWeek;
    }

    public static void main(String[] args) throws IOException, ParseException {
        // TODO Auto-generated method stub

        System.out.println(getCalenderYearWeekList(dateTimestamp.Jan01_2011.timestamp, dateTimestamp.Jan24_2019.timestamp));
        Calendar c = Calendar.getInstance();
        /*DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        c.setTime( sdf.parse("31/12/2010"));
        System.out.println( getWeekFromCalendar(c) );*/
    }

    enum dateTimestamp {
        Jan01_2011(1293840000L),    // Saturday
        Jan01_2018(1514764800L),
        Dec28_2018(1545955200L),
        Dec31_2018(1546214400L),    // Monday
        Jan01_2019(1546300800L),
        Jan24_2019(1548288000L);

        private Long timestamp;

        dateTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }
}
