package WildCardGeneric;

import java.util.ArrayList;
import java.util.List;

public class DemoWildCard {
  public static void drawShape(List<? extends Shape> list){
    for(Shape i : list){
      i.draw();
    }
  }

  public static void main(String[] args) {
    List<Square> listSquare = new ArrayList<>();
    List<Circle> listCircle = new ArrayList<>();

    listCircle.add(new Circle());
    listSquare.add(new Square());

    DemoWildCard demoWildCard = new DemoWildCard();

    drawShape(listCircle);
    drawShape(listSquare);

  }
}
