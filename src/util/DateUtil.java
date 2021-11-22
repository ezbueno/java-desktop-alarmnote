package util;

import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author Ezandro Bueno
 */
public class DateUtil {

    public Date convertToDate(Date date, String hour) {
        String[] timePartitioned = hour.split(":");
        DateTime dateTime = new DateTime(date.getTime());
        dateTime = dateTime.withHourOfDay(Integer.parseInt(timePartitioned[0]))
                .withMinuteOfHour(Integer.parseInt(timePartitioned[1]));

        return dateTime.toDate();
    }
}
