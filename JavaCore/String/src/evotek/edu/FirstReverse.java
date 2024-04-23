package evotek.edu;

public class FirstReverse {

  public static String FirstReverse(String str) {
    String s = "";
    for (int i=str.length()-1; i>=0; i--){
      s = s + String.valueOf(str.charAt(i));
    }
    return s;
  }

  public static void main (String[] args) {
    // keep this function call here
    String s = "coderbyte";
    System.out.print(FirstReverse(s));
  }

}
