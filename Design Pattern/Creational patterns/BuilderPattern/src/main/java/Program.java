import CarParts.Engine;
import CarParts.SeatBelt;
import CarParts.Windscreen;

public class Program {
  public static void main(String[] args) {
    Car car = new Car(4,
        new SeatBelt("OngDev"),
        "red",
        new Windscreen("OngDev"),
        new Engine("Foot"));

    Car carByBuilder = new CarBuilder()
        .addWheels(4)
        .addSeatBelts(new SeatBelt("Ong Dev Seat Belt"))
        .addWindscreen(new Windscreen("Ong Dev wind screen"))
        .addEngine(new Engine("Ong Dev Foot"))
        .paint("red")
        .build();

    System.out.println(car.toString());
    System.out.println("------------------------------------");
    System.out.println(carByBuilder.toString());
  }
}
