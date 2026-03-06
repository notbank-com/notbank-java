package exchange.notbank.fee.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.fee.constants.IntOrderType;

public class IntOrderTypeAdapter {
  Map<Integer, IntOrderType> enumMap = EnumMappingBuilder.buildMapping(IntOrderType.values(), e -> e.value);

  @ToJson
  int toJson(IntOrderType value) {
    return value.value;
  }

  @FromJson
  IntOrderType fromJson(int value) {
    return GetFromMap.get(enumMap, value, IntOrderType.class.getName());
  }
}
