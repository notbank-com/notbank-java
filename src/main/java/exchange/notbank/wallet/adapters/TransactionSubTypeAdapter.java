package exchange.notbank.wallet.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.wallet.constants.TransactionSubType;

public class TransactionSubTypeAdapter {
  Map<Integer, TransactionSubType> enumMap = EnumMappingBuilder.buildMapping(TransactionSubType.values(), e -> e.value);

  @ToJson
  int toJson(TransactionSubType value) {
    return value.value;
  }

  @FromJson
  TransactionSubType fromJson(int value) {
    return GetFromMap.getOrDefault(enumMap, value, TransactionSubType.OTHER);
  }
}
