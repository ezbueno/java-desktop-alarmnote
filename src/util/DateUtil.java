package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author Ezandro Bueno
 */
public class DateUtil {
    
    private static final String DATE_TIME = "dd/MM/yyyy HH:mm";

    public Date convertToDate(Date date, String hour) {
        String[] timePartitioned = hour.split(":");
        DateTime dateTime = new DateTime(date.getTime());
        dateTime = dateTime.withHourOfDay(Integer.parseInt(timePartitioned[0]))
                .withMinuteOfHour(Integer.parseInt(timePartitioned[1]));

        return dateTime.toDate();
    }
    
    private String getDateTimeFormatter() {
        return DATE_TIME;
    }
    
    public String getDateTimeFormatted(Timestamp dateTime) {
        String dateTimeFormatted = "";
        
        if (dateTime != null) {
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat(this.getDateTimeFormatter());
            dateTimeFormatted = dateTimeFormat.format(new Date(dateTime.getTime()));
        }
        return dateTimeFormatted;
    }
}
