package exchange.notbank.wallet.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.wallet.constants.Direction;

public class DirectionAdapter {
  Map<Integer, Direction> enumMap = EnumMappingBuilder.buildMapping(Direction.values(), e -> e.value);
  @ToJson
  int toJson(Direction value) {
    return value.value;
  }

  @FromJson
  Direction fromJson(int value) {
    return GetFromMap.get(enumMap, value, Direction.class.getName());
  }
}
