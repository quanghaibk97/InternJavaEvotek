package evotek.edu.decorators;

import evotek.edu.base.MilkTea;
import evotek.edu.base.MilkTeaDecorator;

public class Bubble extends MilkTeaDecorator {
  public Bubble(MilkTea milkTea) {
    super(milkTea);
  }

  @Override
  public double cost() {
    return 1.0 + super.cost();
  }
}