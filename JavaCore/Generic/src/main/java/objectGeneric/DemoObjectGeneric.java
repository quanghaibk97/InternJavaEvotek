package objectGeneric;

public class DemoObjectGeneric {

  public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    MyGeneric<CodeLearn> myGeneric = new MyGeneric<CodeLearn>(CodeLearn.class);
    myGeneric.getObj().sayHi();
  }
}
