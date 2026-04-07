package exchange.notbank.wallet.paramBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class GetDepositAddressesParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;

  public GetDepositAddressesParamBuilder(Integer accountId, String currency, String network) {
    this(accountId.toString(), currency, network);
  }

  public GetDepositAddressesParamBuilder(String accountId, String currency, String network) {
    this.httpConfiguration = new HttpConfiguration();
    this.params = new HashMap<>();
    this.params.put("account_id", accountId);
    this.params.put("currency", currency);
    this.params.put("network", network);
  }

  public GetDepositAddressesParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public GetDepositAddressesParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public GetDepositAddressesParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
