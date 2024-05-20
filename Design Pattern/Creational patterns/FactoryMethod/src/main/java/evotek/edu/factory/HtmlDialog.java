package evotek.edu.factory;

import evotek.edu.buttons.Button;
import evotek.edu.buttons.HtmlButton;

public class HtmlDialog extends Dialog{
  @Override
  public Button createButton() {
    return new HtmlButton();
  }

}
