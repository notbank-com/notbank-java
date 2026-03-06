package exchange.notbank.fee.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.fee.constants.IntSide;

public class IntSideAdapter {
  Map<Integer, IntSide> enumMap = EnumMappingBuilder.buildMapping(IntSide.values(), e -> e.value);

  @ToJson
  int toJson(IntSide value) {
    return value.value;
  }

  @FromJson
  IntSide fromJson(int value) {
    return GetFromMap.get(enumMap, value, IntSide.class.getName());
  }
}
