package objectGeneric;

public class MyGeneric<T> {
  private T obj;
  public MyGeneric(Class<T> classMyGeneric) throws InstantiationException, IllegalAccessException {
    this.obj = (T) classMyGeneric.newInstance();
  }
  public T getObj(){
    return this.obj;
  }
}
