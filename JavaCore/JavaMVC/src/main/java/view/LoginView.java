package view;

import java.util.Scanner;
import model.LoginModel;

public class LoginView {
  public Scanner scanner = new Scanner(System.in);
  public void showMessage(String sms){
    System.out.println(sms);
  }
  public LoginModel getInfoUser(){
    LoginModel user = new LoginModel();
    System.out.println("Nhập userName: ");
    user.setUserName(scanner.nextLine());
    System.out.println("Nhập passWord: ");
    user.setPassWord(scanner.nextLine());
    return user;
  }

}
