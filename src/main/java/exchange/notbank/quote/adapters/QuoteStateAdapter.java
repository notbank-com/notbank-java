package exchange.notbank.quote.adapters;

import java.util.Map;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.core.adapters.EnumMappingBuilder;
import exchange.notbank.core.adapters.GetFromMap;
import exchange.notbank.quote.constants.QuoteState;

public class QuoteStateAdapter {
  Map<Integer, QuoteState> enumMap = EnumMappingBuilder.buildMapping(QuoteState.values(), e -> e.value);

  @ToJson
  int toJson(QuoteState value) {
    return value.value;
  }

  @FromJson
  QuoteState fromJson(int value) {
    return GetFromMap.get(enumMap, value, QuoteState.class.getName());
  }
}
