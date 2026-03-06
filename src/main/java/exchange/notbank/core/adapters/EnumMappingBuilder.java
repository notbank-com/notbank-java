package exchange.notbank.core.adapters;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumMappingBuilder {
  public static <T extends Enum<T>> Map<Integer, T> buildMapping(T[] anEnum, Function<T, Integer> getInt) {
    return Stream.of(anEnum)
        .map(enumValue -> Map.entry(getInt.apply(enumValue), enumValue))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}
