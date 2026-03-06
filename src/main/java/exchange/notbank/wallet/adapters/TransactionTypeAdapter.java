package exchange.notbank.wallet.adapters;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import exchange.notbank.wallet.constants.TransactionType;

public class TransactionTypeAdapter {
  @ToJson
  int toJson(TransactionType value) {
    return value.value;
  }

  @FromJson
  TransactionType fromJson(int value) {
    try {
      return TransactionType.values()[value];
    } catch (IndexOutOfBoundsException e) {
      return TransactionType.OTHER;
    }
  }
}
