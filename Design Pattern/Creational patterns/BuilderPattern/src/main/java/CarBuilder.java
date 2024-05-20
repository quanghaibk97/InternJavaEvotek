import CarParts.Engine;
import CarParts.SeatBelt;
import CarParts.Windscreen;

public class CarBuilder implements ICarBuilder {
  private int numberOfWheels;
  private SeatBelt seatBelt;
  private String color;
  private Windscreen windscreen;
  private Engine engine;

  @Override
  public CarBuilder addWheels(int numberOfWheels) {
    this.numberOfWheels = numberOfWheels;
    return this;
  }

  @Override
  public CarBuilder addSeatBelts(SeatBelt seatBelt) {
    this.seatBelt = seatBelt;
    return this;
  }

  @Override
  public CarBuilder paint(String color) {
    this.color = color;
    return this;
  }

  @Override
  public CarBuilder addWindscreen(Windscreen windscreen) {
    this.windscreen = windscreen;
    return this;
  }

  @Override
  public CarBuilder addEngine(Engine engine) {
    this.engine = engine;
    return this;
  }

  @Override
  public Car build() {
    return new Car(numberOfWheels, seatBelt, color, windscreen, engine);
  }
}
