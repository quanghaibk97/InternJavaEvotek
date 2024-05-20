package evotek.edu.base;

public abstract class MilkTeaDecorator implements MilkTea {
  private MilkTea milkTea;

  protected MilkTeaDecorator(MilkTea milkTea) {
    this.milkTea = milkTea;
  }

  @Override
  public double cost() {
    return milkTea.cost();
  }
}
