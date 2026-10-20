package exchange.notbank.verification.constants;

import com.squareup.moshi.Json;

public enum VerificationLevel {
  @Json(name = "basic") BASIC,
  @Json(name = "trader") TRADER,
  @Json(name = "trader_plus") TRADER_PLUS,
  @Json(name = "institutional") INSTITUTIONAL;
}
