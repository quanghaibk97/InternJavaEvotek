package evotek.edu;

public class StringChallenge {
  public static String StringChallenge(String str) {
    int j = 0;
    String str2 = "";
    for(int i=0; i<str.length()-1; i++){
      if(Integer.valueOf(str.charAt(i))%2 !=0 && Integer.valueOf(str.charAt(i+1))%2 !=0) {
        str2 = str2 + str.charAt(i) + "-";
      } else {
        str2 = str2 + str.charAt(i) ;
      }
    }
    // code goes here
    return str2;

  }

  public static void main (String[] args) {
    // keep this function call here
    String s = "1529788";
    System.out.print(StringChallenge(s));
  }
}
