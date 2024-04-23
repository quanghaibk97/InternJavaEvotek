package evotek.edu;

public class BracketMatcher {
  public static String BracketMatcher(String str) {
    int left = 0;
    int right = 0;
    for (int i=0; i<str.length(); i++){
      if(str.substring(i, i+1).equals("(")){
        left++;
      } else if (str.substring(i, i+1).equals(")")){
        right++;
      }
      if (left < right) return "0";
    }
    if(left != right) return "0";
    return "1";
  }


  public static void main (String[] args) {
    // keep this function call here
    String s = "letter(s) gal(o)(r)((e)";
    System.out.print(BracketMatcher(s));
  }

}
