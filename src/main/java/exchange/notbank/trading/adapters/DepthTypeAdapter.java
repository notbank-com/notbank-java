package exchange.notbank.trading.adapters;

import com.squareup.moshi.ToJson;

import exchange.notbank.trading.constants.DepthType;

public class DepthTypeAdapter {
  @ToJson
  int toJson(DepthType value) {
    return value.value;
  }
}
