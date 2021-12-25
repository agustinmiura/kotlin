package java.ar.com.miura.string;

public class DateDiff {
    private static final String FORMAT = "yyyy-MM-dd";
    private static final java.text.SimpleDateFormat FORMATTER = new java.text.SimpleDateFormat(FORMAT);

    public int daysBetweenDates(String date1, String date2) {
        try {
            final java.time.Instant dateOne = FORMATTER.parse(date1).toInstant();
            final java.time.Instant dateTwo = FORMATTER.parse(date2).toInstant();
            final java.time.Duration duration = java.time.Duration.between(dateOne, dateTwo);
            return (int) Math.abs(duration.toDays());
        } catch (java.text.ParseException error) {
            throw new RuntimeException("Failed to parse date.", error);
        }
    }
}
