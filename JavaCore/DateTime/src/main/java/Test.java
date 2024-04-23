import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class Test {

  public static void main(String[] args) {
//    ZoneId zoneIdDefault = ZoneId.systemDefault();
//    ZoneId zoneId = ZoneId.of("Australia/Sydney");
//    LocalTime localTime = LocalTime.now(zoneId);
//    System.out.println("Now is: " + localTime); // 03:56:06.006877 (Example)

//    DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    LocalDate localDate2 = LocalDate.parse("20/11/2020", fmt2);
//    System.out.println("localDate2: " + localDate2); // 2011-11-20

    LocalDate localDate1 = LocalDate.of(2020, 1, 15);
    System.out.println("localDate1: " + localDate1); // 2020-01-15
  }

}
