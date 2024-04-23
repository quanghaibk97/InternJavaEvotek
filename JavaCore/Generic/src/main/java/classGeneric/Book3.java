package classGeneric;

public class Book3<K, V, I> extends Dictionary{
  private I info;
  public Book3(Object key, Object value, I info) {
    super(key, value);
    this.info = info;
  }

  public I getInfo() {
    return info;
  }

  public void setInfo(I info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return "Book3{" +
        "info=" + info +
        ", key=" + this.getKey() +
        ", value=" + this.getValue() +
        '}';
  }
}
