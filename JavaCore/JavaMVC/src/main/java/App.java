import controller.LoginController;
import view.LoginView;

public class App {

  public static void main(String[] args) {
    LoginView view = new LoginView();
    LoginController controller = new LoginController(view);
    controller.login();

  }


}
