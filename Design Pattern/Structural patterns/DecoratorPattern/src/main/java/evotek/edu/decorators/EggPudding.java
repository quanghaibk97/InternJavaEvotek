package evotek.edu.decorators;

import evotek.edu.base.MilkTea;
import evotek.edu.base.MilkTeaDecorator;

public class EggPudding extends MilkTeaDecorator {
  public EggPudding(MilkTea milkTea) {
    super(milkTea);
  }

  @Override
  public double cost() {
    return 3.0 + super.cost();
  }
}