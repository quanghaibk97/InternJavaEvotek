package immutableClass;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableClass {
  private final int num;
  private final HashMap<String, String> hashmap;
  public ImmutableClass(int num, HashMap<String,String> hashmap) {
    this.num = num;
    this.hashmap = new HashMap<String,String>(hashmap);
  }
  public int getNum() {
    return num;
  }
  //Collections.unmodifiableMap ⇒ create a copy of original map and make it read-only, if user try to modify it, throw UnSupportedOperationException
  public Map<String,String> getHashMap() {
    return Collections.unmodifiableMap(hashmap);
  }

  public static void main(String[] args) {
    HashMap<String, String> originalMap = new HashMap<>();
    originalMap.put("key1", "value1");
    originalMap.put("key2", "value2");

    ImmutableClass immutableObject = new ImmutableClass(42, originalMap);

    // Trying to modify the originalMap
    originalMap.put("key3", "value3");
    System.out.println(immutableObject.getHashMap());

    // Trying to modify the returned hashMap
    Map<String, String> returnedMap = immutableObject.getHashMap();
    returnedMap.put("key4", "value4"); // throw exception
  }
}
