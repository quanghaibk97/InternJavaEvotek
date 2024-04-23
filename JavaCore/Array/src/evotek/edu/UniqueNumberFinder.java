package evotek.edu;

import java.util.Arrays;

public class UniqueNumberFinder {
  public static void main(String[] args) {
    int arr[] = {10, 20, 10, 30, 50, 80, 60, 55, 88, 20, 50, 30, 55, 60, 88, 10};
    Arrays.sort(arr);
    if (arr[0] != arr[1]) {
      System.out.println(arr[0]);
    } else if (arr[arr.length - 1] != arr[arr.length - 2]) {
      System.out.println(arr[arr.length - 1]);
    } else {
      for (int i = 1; i < arr.length - 1; i++) {
        if (arr[i] != arr[i + 1] && arr[i] != arr[i - 1]) {
          System.out.println(arr[i]);
          break;
        }
      }
    }
  }

}
