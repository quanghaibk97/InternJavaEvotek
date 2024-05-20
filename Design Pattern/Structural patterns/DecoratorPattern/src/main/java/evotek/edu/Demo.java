package evotek.edu;

import evotek.edu.base.MilkTea;
import evotek.edu.base.SimpleMilkTea;
import evotek.edu.decorators.BlackSugar;
import evotek.edu.decorators.Bubble;
import evotek.edu.decorators.EggPudding;
import evotek.edu.decorators.FruitPudding;
import evotek.edu.decorators.WhiteBubble;

public class Demo {
  public static void main(String[] args) {

    MilkTea firstMilkTea = new EggPudding(
        new FruitPudding(
            new BlackSugar(
                new Bubble(
                    new SimpleMilkTea()))));
    System.out.println("EggPuddingAndFruitPuddingBlackSugarBubbleMilkTea:\t" + firstMilkTea.cost());

    MilkTea secondMilkTea = new EggPudding(
        new BlackSugar(
            new WhiteBubble(
                new SimpleMilkTea())));
    System.out.println("EggPuddingBlackSugarWhiteBubbleMilkTea:\t" + secondMilkTea.cost());
  }
}
