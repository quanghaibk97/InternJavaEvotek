package dynamicProgramming;

public class LongestIncreasingSubsequence {

  // Sửa lần 3
  // Sửa lần 1
  public static void main(String[] args) {
    int arr1[] = {128,104, 53, 876, 660, 961, 754, 775, 290, 231};
    System.out.println(max(arr1));
  }
  public static int max(int[] a){
    int maxLength = 1;
    int n = a.length;
    int f[] = new int[n];
    f[0] = 1;
    for (int i=1; i<a.length; i++){
      int max1 = 0;
      for (int j=0; j<i; j++){
        System.out.println("i = " + i + "   j = " + j);
        if (a[i] > a[j]){
          max1 = Math.max(max1, f[j] + 1);
          System.out.println("max1 = " + max1);
        }
      }
      f[i] = max1;
      if(max1 > maxLength) maxLength = max1;
    }
    return maxLength;
  }
}
