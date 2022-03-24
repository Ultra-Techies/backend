package app.ultratechies.api.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static Instant convertStringToInstant(String timestamp) {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime
                .parse(timestamp, formatter)
                .atZone(ZoneId.systemDefault())
                .toInstant();
    }

    public static String convertInstantToString(Instant date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return dateTimeFormatter.format(date);
    }
}