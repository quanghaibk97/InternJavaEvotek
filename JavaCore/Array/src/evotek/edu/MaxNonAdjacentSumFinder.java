package evotek.edu;

public class MaxNonAdjacentSumFinder {
  public static void main(String[] args) {
    int arr[] = {2,20,9,3,10};
    maxArray(arr);
  }

  public static void maxArray(int[] arr){
    if(arr == null) {
      System.out.println(0);
    } else if (arr.length == 1) {
      System.out.println(arr[0]);;
    } else if(arr.length == 2){
      System.out.println(Math.max(arr[0], arr[1])); ;
    } else {
      int maxSum[] = new int[arr.length];
      maxSum[0] = arr[0];
      maxSum[1] = Math.max(arr[1], arr[0]);
      for (int i = 2; i < arr.length;i++){
        maxSum[i] = Math.max(arr[i] + maxSum[i-2], maxSum[i-1]);
      }
      System.out.println(maxSum[arr.length-1]);
    }
  }
}
