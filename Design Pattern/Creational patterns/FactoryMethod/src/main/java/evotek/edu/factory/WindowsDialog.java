package evotek.edu.factory;

import evotek.edu.buttons.Button;
import evotek.edu.buttons.WindowsButton;

public class WindowsDialog extends Dialog{
  @Override
  public Button createButton() {
    return new WindowsButton();
  }

}
