import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("d['st']['nd']['rd']['th'] MMMM yyyy");

    // Parses date input from user
    public static LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            return null; // Return null if the date format is incorrect
        }
    }

    // Formats date output to "2nd December 2025"
    public static String formatDate(LocalDate date) {
        if (date == null) return "Invalid date";

        int day = date.getDayOfMonth();
        String daySuffix = getDaySuffix(day);

        return day + daySuffix + " " + date.format(DateTimeFormatter.ofPattern("MMMM yyyy"));
    }

    // Determines the suffix for the day (1st, 2nd, 3rd, 4th...)
    private static String getDaySuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th"; // Special case for 11th, 12th, 13th
        }
        switch (day % 10) {
        case 1: return "st";
        case 2: return "nd";
        case 3: return "rd";
        default: return "th";
        }
    }
}