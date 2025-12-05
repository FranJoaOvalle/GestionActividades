package utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Fechas {
    public static final DateTimeFormatter DATE_CL =
            DateTimeFormatter.ofPattern("dd-MM-uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

    public static final DateTimeFormatter DATE_SQLITE =
            DateTimeFormatter.ofPattern("uuuu-MM-dd")
                    .withResolverStyle(ResolverStyle.STRICT);

    public static LocalDate unixALocalDate(long unix) {
        return Instant.ofEpochSecond(unix).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static long localDateAUnix(LocalDate date) {
        return date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
    }

    public static LocalTime minutosALocalTime(int minutos) {
        return LocalTime.of(minutos / 60, minutos % 60);
    }

    public static int localTimeAMinutos(LocalTime tiempo) {
        return tiempo.getHour() * 60 + tiempo.getMinute();
    }
}
