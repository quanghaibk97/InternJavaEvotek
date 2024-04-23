package controller;

import model.LoginModel;
import view.LoginView;

public class LoginController {
  private LoginView view;

  public LoginView getView() {
    return view;
  }
  public void setView(LoginView view) {
    this.view = view;
  }

  public LoginController() {
  }

  public LoginController(LoginView view) {
    this.view = view;
  }

  public void login() {
    while (true) {
      LoginModel user = view.getInfoUser();
      if (checkInfoUser(user)) {
        view.showMessage("Logged in successfully");
        break;
      } else {
        view.showMessage("User account or password incorrect");
      }
    }

  }

  public boolean checkInfoUser(LoginModel user) {
    if (user.getUserName().equals("admin") && user.getPassWord().equals("admin")) {
      return true;
    } else {
      return false;
    }
  }
}
