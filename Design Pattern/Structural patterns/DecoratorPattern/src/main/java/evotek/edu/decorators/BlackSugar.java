package evotek.edu.decorators;

import evotek.edu.base.MilkTea;
import evotek.edu.base.MilkTeaDecorator;

public class BlackSugar extends MilkTeaDecorator {
  public BlackSugar(MilkTea milkTea) {
    super(milkTea);
  }

  @Override
  public double cost() {
    return 2.0 + super.cost();
  }
}
