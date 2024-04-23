package evotek.edu;

public class MinWindowSubstring {

  public static String MinWindowSubstring(String[] strArr) {
    String str1 = strArr[0];
    String str2 = strArr[1];
    int min = str1.length()+1;
    String str3 = new String();
    for (int i=0; i<str1.length(); i++){
      StringBuilder str4 = new StringBuilder(str2);
      for (int j=i; j<str1.length();j++){
        if(str4.toString().contains(String.valueOf(str1.charAt(j)))){
          int index = str4.indexOf(String.valueOf(str1.charAt(j)));
          str4.replace(index, index+1, "");
        }

        if (str4.length() == 0){
          System.out.println("i=" + i + "  j=" + j);
          if (min > j-i+1){
            min = j-i+1;
            str3 = str1.substring(i,j+1);
          }
        }
      }
    }
    return str3;
  }

  public static void main (String[] args) {
    // keep this function call here
    String[] s = {"caae", "cae"};
    System.out.print(MinWindowSubstring(s));
  }
}
