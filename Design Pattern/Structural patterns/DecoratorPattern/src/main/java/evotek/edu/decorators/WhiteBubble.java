package evotek.edu.decorators;

import evotek.edu.base.MilkTea;
import evotek.edu.base.MilkTeaDecorator;

public class WhiteBubble extends MilkTeaDecorator {
  public WhiteBubble(MilkTea milkTea) {
    super(milkTea);
  }

  @Override
  public double cost() {
    return 1.5 + super.cost();
  }
}