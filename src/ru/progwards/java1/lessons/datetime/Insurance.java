package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import static java.util.Date.parse;

public class Insurance {

    public static void main(String[] args) {
        Insurance insurance = new Insurance("2020-02-16T19:49:38.3652724+03:00[Europe/Moscow]", FormatStyle.FULL);
        System.out.println(insurance.start);

    }

    public static enum FormatStyle {SHORT, LONG, FULL}

    private ZonedDateTime start;
    private Duration duration;

    public Insurance(ZonedDateTime start) {
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style) {
        switch (style) {
            case SHORT:
                LocalDate ld = LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(strStart));
                LocalTime lt = LocalTime.of(0, 0, 0);
                this.start = ZonedDateTime.of(ld, lt, ZoneId.systemDefault());
                break;
            case LONG:
                LocalDateTime ltd = LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse(strStart));
                this.start = ZonedDateTime.of(ltd, ZoneId.systemDefault());
                break;
            case FULL:
                DateTimeFormatter dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                this.start = ZonedDateTime.parse(strStart, dtf);
                break;
        }


    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration) {
        this.duration = Duration.between(start, expiration);
    }

    public void setDuration(String strDuration, FormatStyle style) {
        switch (style) {
            case SHORT:
                this.duration = Duration.ofMillis(Long.parseLong(strDuration));
                break;
            case LONG:
                LocalDateTime ltd = LocalDateTime.from(DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("0000-00-00T00:00:00"));
                ZonedDateTime zdtt = ZonedDateTime.of(ltd, ZoneId.systemDefault());
                DateTimeFormatter dtf = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                ZonedDateTime zdt = ZonedDateTime.parse(strDuration, dtf);
                this.duration = Duration.between(zdtt, zdt);
                break;
            case FULL:
                this.duration = Duration.parse(strDuration);
                break;
        }
    }

    public boolean checkValid(ZonedDateTime dateTime) {
        if (dateTime == null) return true;
        if (Duration.between(start, dateTime).toMinutes() < this.duration.toMinutes()) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if (checkValid(ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()))) {
            return "Insurance issued on " + start + " is valid";
        } else {
            return "Insurance issued on " + start + " is not valid";
        }

    }
}
