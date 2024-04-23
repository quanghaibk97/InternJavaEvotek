package classGeneric;

public class DemoGeneric {
  public static void main(String[] args) {
    Dictionary<String, String> dictionary = new Dictionary<>("study","hoc");
    System.out.println(dictionary);

    Book book = new Book("Hello", "Xin chao");
    System.out.println(book);

    Book2<String, String> book2 = new Book2<>("User name", "Tên người dùng");
    System.out.println(book2);

    Book3<String, String, String> book3 = new Book3<>("User name", "Tên người dùng", "Test");
    System.out.println(book3);
  }
}
