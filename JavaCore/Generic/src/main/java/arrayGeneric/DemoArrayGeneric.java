package arrayGeneric;

public class DemoArrayGeneric {

  public static void main(String[] args) {
    String[] names = new String[] { "Dat", "Khoa", "Tin" };

    MyArrayGeneric<String> myArrayGeneric = new MyArrayGeneric<>(names);
    myArrayGeneric.getFirstElement();
    myArrayGeneric.getLastElement();
  }
}
