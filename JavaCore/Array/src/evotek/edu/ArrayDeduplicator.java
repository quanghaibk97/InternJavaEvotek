package evotek.edu;

import java.util.Arrays;

public class ArrayDeduplicator {
  public static int remove(int arr[], int n){
    if (n==0 || n==1){
      return n;
    }
    int j = 0;
    for (int i=0; i < n-1; i++){
      if (arr[i] != arr[i+1]){
        arr[j++] = arr[i];
      }
    }
    arr[j++] = arr[n-1];
    return j;
  }

  public static void main (String[] args) {
    int arr1[] = {10,70,30,90,20,20,30,40,70,50};
    Arrays.sort(arr1);
    int length1 = arr1.length;
    String arr2[] = new String[length1];

    int length2 = remove(arr1, length1);

    for (int i=0; i<length1; i++)  {
      if(i<length2) {
        arr2[i] = String.valueOf(arr1[i]);
      } else {
        arr2[i] = "*";
      }
    }
    for (int i=0; i<length1; i++){
      System.out.print(arr2[i] + " ");
    }

  }

}
