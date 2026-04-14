package exchange.notbank.wallet.responses;

import com.squareup.moshi.Json;

public class WithdrawalConfigurationStatus {
  public final Boolean enabled;

  public WithdrawalConfigurationStatus(Boolean twoFactorAuthenticationStatus) {
    this.enabled = twoFactorAuthenticationStatus;
  }
}
