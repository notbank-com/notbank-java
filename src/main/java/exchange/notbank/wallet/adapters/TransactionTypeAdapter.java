package exchange.notbank.wallet.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.wallet.constants.TransactionType;

public class TransactionTypeAdapter {
  Map<Integer, TransactionType> enumMap = EnumMappingBuilder.buildMapping(TransactionType.values(), e -> e.value);

  @ToJson
  int toJson(TransactionType value) {
    return value.value;
  }

  @FromJson
  TransactionType fromJson(int value) {
    return GetFromMap.getOrDefault(enumMap, value, TransactionType.OTHER);
  }
}
