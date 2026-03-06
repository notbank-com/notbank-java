package exchange.notbank.wallet.adapters;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.wallet.constants.TransactionSubType;

public class TransactionSubTypeAdapter {
  @ToJson
  int toJson(TransactionSubType value) {
    return value.value;
  }

  @FromJson
  TransactionSubType fromJson(int value) {
    try {
      return TransactionSubType.values()[value];
    } catch (IndexOutOfBoundsException e) {
      return TransactionSubType.OTHER;
    }
  }
}
