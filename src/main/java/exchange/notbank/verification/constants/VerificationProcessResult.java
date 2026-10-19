package exchange.notbank.verification.constants;

import com.squareup.moshi.Json;

public enum VerificationProcessResult {
  @Json(name = "approved") APPROVED,
  @Json(name = "rejected") REJECTED;
}
