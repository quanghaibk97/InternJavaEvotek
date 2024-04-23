package evotek.edu;

public class ThreeSumZeroFinder {
  public static void main(String[] args) {
    int arr1[] = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6};
    int arr2[][] = new int[3000][3];
    int t = 0;
    for (int i = 0; i < arr1.length-2; i++){
      for (int j=0; j<arr1.length-1; j++){
        for (int k=0; k<arr1.length; k++){
          if(arr1[i] + arr1[j] + arr1[k] == 0) {
            arr2[t][0] = arr1[i];
            arr2[t][1] = arr1[j];
            arr2[t][2] = arr1[k];
            t++;
          }
        }
      }
    }

    for (int i = 0; i < t-1; i++){
      for (int j=0; j<3; j++){
        System.out.print(arr2[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
