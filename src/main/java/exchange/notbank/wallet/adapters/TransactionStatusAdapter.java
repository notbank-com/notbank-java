package exchange.notbank.wallet.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.wallet.constants.TransactionStatus;

public class TransactionStatusAdapter {
  Map<Integer, TransactionStatus> enumMap = EnumMappingBuilder.buildMapping(TransactionStatus.values(), e -> e.value);

  @ToJson
  int toJson(TransactionStatus value) {
    return value.value;
  }

  @FromJson
  TransactionStatus fromJson(int value) {
    return GetFromMap.getOrDefault(enumMap, value, TransactionStatus.OTHER);
  }
}
