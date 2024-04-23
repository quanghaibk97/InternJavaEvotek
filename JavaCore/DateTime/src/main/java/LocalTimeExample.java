import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTimeExample {


  public static void main(String[] args) {
    LocalTime localTime = LocalTime.now();
    LocalDate localDate = LocalDate.now();
    LocalDateTime localDateTime = localTime.atDate(localDate);
    System.out.println(localDateTime);
  }
}
