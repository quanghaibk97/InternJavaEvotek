import CarParts.Engine;
import CarParts.SeatBelt;
import CarParts.Windscreen;

public class Car {

  private int numberOfWheels;
  private SeatBelt seatBelt;
  private String color;
  private Windscreen windscreen;
  private Engine engine;

  public Car(int numberOfWheels, SeatBelt seatBelt, String color, Windscreen windscreen,
      Engine engine) {
    this.numberOfWheels = numberOfWheels;
    this.seatBelt = seatBelt;
    this.color = color;
    this.windscreen = windscreen;
    this.engine = engine;
  }

  @Override
  public String toString() {
    StringBuilder content = new StringBuilder();
    content.append("Number of wheels:     \t").append(numberOfWheels).append("\n");
    content.append("Brand of seat belts:  \t").append(seatBelt.getBrand()).append("\n");
    content.append("Color:                \t").append(color).append("\n");
    content.append("Windscreen brand:     \t").append(windscreen.getName()).append("\n");
    content.append("Engine:               \t").append(engine.getName());
    return content.toString();
  }
}