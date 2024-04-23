import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class LocalDateTimeExemple {

  public static void main(String[] args) {
    LocalDate ld = LocalDate.now();
    System.out.println(ld);

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    System.out.println(dtf.format(ld));
    System.out.println(ld.format(dtf));
    String str = "01-02-2024";
    System.out.println(LocalDate.parse(str, dtf));
    System.out.println(ld.getMonth());

    LocalTime lt = LocalTime.now();
    System.out.println(lt);
    LocalDateTime ldt = LocalDateTime.now();
    System.out.println(ldt);

    Period period = Period.ofDays(5);
    System.out.println(period.plus(period));
    period = period.of(3,2,1);
    System.out.println(ld.minus(period));

    Duration duration = Duration.ofHours(5);
    System.out.println(lt.plus(duration));

    ZoneId timeZone = ZoneId.of("Asia/Bangkok");
    ZonedDateTime zonedDateTime = ZonedDateTime.of(ldt, timeZone);
    System.out.println(zonedDateTime);
    String newTimeZone = "2024-04-08T17:16:45.193+07:00[Asia/Singapore]";
    System.out.println(zonedDateTime.parse(newTimeZone));

  }
}
