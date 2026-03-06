package exchange.notbank.fee.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.fee.constants.MakerTaker;

public class MakerTakerAdapter {
  Map<Integer, MakerTaker> enumMap = EnumMappingBuilder.buildMapping(MakerTaker.values(), e -> e.value);

  @ToJson
  int toJson(MakerTaker value) {
    return value.value;
  }

  @FromJson
  MakerTaker fromJson(int value) {
    return GetFromMap.get(enumMap, value, MakerTaker.class.getName());
  }
}
