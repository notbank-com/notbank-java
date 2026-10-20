package exchange.notbank.verification.responses;

import com.squareup.moshi.Json;

import exchange.notbank.verification.constants.VerificationLevel;
import exchange.notbank.verification.constants.VerificationProcessResult;

public class VerificationStatus {
  public final String id;
  public final Boolean locked;
  @Json(name = "next_level") public final VerificationLevel nextLevel;
  @Json(name = "last_previous_status") public final VerificationProcessResult lastPreviousStatus;
  @Json(name = "last_previous_reason") public final String lastPreviousReason;
  @Json(name = "is_business") public final Boolean isBusiness;
  @Json(name = "verification_tier") public final Integer verificationTier;

  public VerificationStatus(String id, Boolean locked, VerificationLevel nextLevel,
      VerificationProcessResult lastPreviousStatus, String lastPreviousReason, Boolean isBusiness,
      Integer verificationTier) {
    this.id = id;
    this.locked = locked;
    this.nextLevel = nextLevel;
    this.lastPreviousStatus = lastPreviousStatus;
    this.lastPreviousReason = lastPreviousReason;
    this.isBusiness = isBusiness;
    this.verificationTier = verificationTier;
  }

  @Override
  public String toString() {
    return "VerificationStatus [id=" + id + ", locked=" + locked + ", nextLevel=" + nextLevel
        + ", lastPreviousStatus=" + lastPreviousStatus + ", lastPreviousReason=" + lastPreviousReason
        + ", isBusiness=" + isBusiness + ", verificationTier=" + verificationTier + "]";
  }
}
