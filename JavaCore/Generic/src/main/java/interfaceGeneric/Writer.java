package interfaceGeneric;

public interface Writer<T> {
  void update(T obj);
  void delete(T obj);
  void write(T obj);

}
