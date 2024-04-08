package sort;

import java.util.Arrays;

public class QuickSort {
  public static void main(String[] args) {
    int[] array = {12,13,24,10,3,6,90,70};
    quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }
  public static  void quickSort(int a[], int left, int right) {
    int i = left, j = right;
    int pivot = a[left + (right - left)/2];
    // chia dãy thành 2 phần
    while (i <= j) {
      while (a[i] < pivot) ++i;
      while (a[j] > pivot) --j;

      if (i <= j) {
        swap(a, i, j);
        ++i;
        --j;
      }
    }
    // Gọi đệ quy để sắp xếp các nửa
    if (left < j) quickSort(a, left, j);
    if (i < right) quickSort(a, i, right);
  }

  public static void swap(int a[], int i, int j){
    int temp = a[i];
    a[i] = a[j];
    a[j]= temp;
  }

}
