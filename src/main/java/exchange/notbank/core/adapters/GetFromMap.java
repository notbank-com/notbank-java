package exchange.notbank.core.adapters;

import java.util.Map;

import com.squareup.moshi.JsonDataException;

public class GetFromMap {
  public static <T extends Enum<T>> T get(Map<Integer, T> enumMap, Integer value, String enumName) {
    var state = enumMap.get(value);
    if (state == null) {
      throw new JsonDataException("Invalid " + enumName + ". unknown value of " + value);
    }
    return state;
  }

  public static <T extends Enum<T>> T getOrDefault(Map<Integer, T> enumMap, Integer value, T defaultValue) {
    var state = enumMap.get(value);
    if (state == null) {
      return defaultValue;
    }
    return state;
  }
}
