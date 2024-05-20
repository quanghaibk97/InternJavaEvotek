import CarParts.Engine;
import CarParts.SeatBelt;
import CarParts.Windscreen;

public interface ICarBuilder {
  CarBuilder addWheels(int numberOfWheels);
  CarBuilder addSeatBelts(SeatBelt seatBelt);
  CarBuilder paint(String color);
  CarBuilder addWindscreen(Windscreen windscreen);
  CarBuilder addEngine(Engine engine);
  Car build();
}
