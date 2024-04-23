package evotek.edu;

public class LongestWord {

  public static String LongestWord(String sen) {
    String str = "";
    String temp = "";
    int lenMax = 0;
    for(int i=0; i<sen.length(); i++){
      if(!Character.isDigit(sen.charAt(i)) && !Character.isLetter(sen.charAt(i))){
        temp = "";
      } else {
        temp = temp + String.valueOf(sen.charAt(i));
        if(str.length() < temp.length())
          str = temp;
      }
    }
    return str;
  }

  public static void main(String[] args) {
    // keep this function call here
    String s = "fun&!! time";
    System.out.print(LongestWord(s));
  }

}
