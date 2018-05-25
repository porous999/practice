package HelloWorld;

import static Extra.Utils.CalendarUtils.getCalenderYearWeekList;

public class HelloWorld {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Hello world!!");
        //System.out.println("abcd".compareTo("abcde"));
        System.out.println(getCalenderYearWeekList(dateTimestamp.Jan01_2011.timestamp, dateTimestamp.Jan24_2019.timestamp));
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
