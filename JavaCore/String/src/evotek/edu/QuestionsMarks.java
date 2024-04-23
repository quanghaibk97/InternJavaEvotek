package evotek.edu;

public class QuestionsMarks {

//  public static Boolean QuestionsMarks(String str) {
//    int count1 = 0;
//    for (int i = 0; i < str.length()-1; i++) {
//      if (Character.isDigit(str.charAt(i))) {
//        for (int j = i + 1; j < str.length(); j++) {
//          if (Character.isDigit(str.charAt(j))) {
//            if (Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(j))
//                == 10) {
//              count1++;
//              if (j - i < 4) {
//                return false;
//              } else {
//                int count2 = 0;
//                for (int k = i + 1; k < j; k++) {
//                  if (str.charAt(k) == '?') {
//                    count2++;
//                  }
//                }
//                if (count2 != 3) {
//                  return false;
//                }
//              }
//            }
//            i = j-1;
//            break;
//          }
//        }
//      }
//    }
//    if (count1 == 0) {
//      return false;
//    } else {
//      return true;
//    }
//  }
//
//  public static void main(String[] args) {
//    // keep this function call here
//    String s = "5??aaaaaaaaaaaaaaaaaaa?5?5";
//    System.out.print(QuestionsMarks(s));
//  }

  public static Boolean QuestionsMarks(String str) {
    int count1 = 0;
    for (int i = 0; i < str.length()-1; i++) {
      if(!Character.isDigit(str.charAt(i))) continue;
      for (int j = i + 1; j < str.length(); j++) {
        if(!Character.isDigit(str.charAt(j))) continue;
        if (Character.getNumericValue(str.charAt(i)) + Character.getNumericValue(str.charAt(j))
            == 10) {
          count1++;
          if (j - i < 4) {
            return false;
          } else {
            int count2 = 0;
            for (int k = i + 1; k < j; k++) {
              if (str.charAt(k) == '?') {
                count2++;
              }
            }
            if (count2 != 3) {
              return false;
            }
          }
        }
        i = j-1;
        break;
      }
    }
    if (count1 == 0) return false;
      return true;
  }

  public static void main(String[] args) {
    // keep this function call here
    String s = "5??aaaaaaaaaaaaaaaaaaa?5?5";
    System.out.print(QuestionsMarks(s));
  }

}
