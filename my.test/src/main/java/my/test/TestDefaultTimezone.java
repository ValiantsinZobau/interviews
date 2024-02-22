package my.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class TestDefaultTimezone {
	public static void main(String[] args) throws Exception {
//		
//		ZoneId.getAvailableZoneIds().stream().forEach((zone) -> {
//			System.out.println(zone);
//		});
		System.out.println(ZoneId.systemDefault());
		System.out.println(ZoneId.of("America/Chicago"));
		System.out.println(LocalDateTime.now());
		System.out.println(LocalDateTime.now(ZoneId.of("America/Chicago")));
		System.out.println(LocalDateTime.now(ZoneId.of("Africa/Bissau")));
		
		System.out.println(LocalDateTime.now(ZoneId.of("SystemV/CST6CDT")));
		
		System.out.println(new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").parse("19-07-1983 15-19-23"));
		
		System.out.println(Math.floor(9.99));
		
		testWinterTime();
	}
	
    public static void testWinterTime() throws Exception {
        TimeZone tz = TimeZone.getTimeZone("America/Chicago");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2018, Calendar.MARCH, 11, 6, 59, 0);
//        11-03-2018 02-00-00 CDT
        for (int i = 0; i < 62; i++) {
            String mark = dateFormat.format(calendar.getTime());
            System.out.printf("%s - %d, %s\n", mark,
                    tz.getOffset(calendar.getTimeInMillis()),
                    tz.inDaylightTime(calendar.getTime()));
            calendar.add(Calendar.MINUTE, +1);
        }
    }
}
