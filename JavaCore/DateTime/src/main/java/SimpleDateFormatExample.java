import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
  public static void main(String[] args) throws ParseException {
    Date date1= new Date();
    System.out.println(date1);
    System.out.println(date1.getTime());
    System.out.println(date1.getHours());
    System.out.println(date1.after(new Date()));

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm");
    System.out.println(sdf.format(date1));
    Date date2 = sdf.parse("01-05-2024 16-36");
    System.out.println(date2);
    System.out.println(sdf.format(date2));
  }
}
