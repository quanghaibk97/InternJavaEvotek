package evotek.edu;

import java.util.Scanner;

public class CodelandUsernameValidation {
  public static String CodelandUsernameValidation(String str) {
    if (str.length() < 4 || str.length() > 25) {
      return "false";
    } else if (!Character.isLetter(str.charAt(0))) {
      return "false";
    } else if (str.endsWith("_")) {
      return "false";
    }
    for (int i = 0; i < str.length(); i++) {
      if (!Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i))
          && !(str.charAt(i) == '_')) {
        return "false";
      }
    }

    return "true";
  }

  public static void main(String[] args) {
    System.out.println("Nhập vào String:");
    Scanner s = new Scanner(System.in);
    System.out.print(CodelandUsernameValidation(s.nextLine()));
  }
}
