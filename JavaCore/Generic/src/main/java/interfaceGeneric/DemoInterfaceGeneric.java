package interfaceGeneric;

public class DemoInterfaceGeneric {
  public static void main(String[] args) {
    Book<String> t = new Book<String>();
    t.write("Add data to book");
  }
}
