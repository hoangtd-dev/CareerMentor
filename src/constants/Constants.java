package constants;

import java.time.format.DateTimeFormatter;

public class Constants {
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d");
	public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d'T'HH:mm:ss");
}
