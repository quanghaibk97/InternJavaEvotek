package methodGeneric;

import java.util.ArrayList;
public class Strore {
  public static<E> E getFirstElement(ArrayList<E> arrayList){
    if(arrayList.isEmpty()){
      return null;
    } else {
      E first = arrayList.get(0);
      return first;
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> arrayList= new ArrayList<>();
    arrayList.add(1);
    arrayList.add(3);
    arrayList.add(5);
    System.out.println(Strore.getFirstElement(arrayList));

  }
}
