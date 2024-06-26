package evotek.edu.factory;

import evotek.edu.buttons.Button;

public abstract class Dialog {
  public void renderWindow() {
    // ... other code ...

    Button okButton = createButton();
    okButton.render();
  }
  public abstract Button createButton();
}
