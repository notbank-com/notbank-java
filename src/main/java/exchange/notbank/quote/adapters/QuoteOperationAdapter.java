package exchange.notbank.quote.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.quote.constants.QuoteOperation;

public class QuoteOperationAdapter {
  Map<Integer, QuoteOperation> enumMap = EnumMappingBuilder.buildMapping(QuoteOperation.values(), e -> e.value);

  @ToJson
  int toJson(QuoteOperation value) {
    return value.value;
  }

  @FromJson
  QuoteOperation fromJson(int value) {
    return GetFromMap.get(enumMap, value, QuoteOperation.class.getName());
  }
}
