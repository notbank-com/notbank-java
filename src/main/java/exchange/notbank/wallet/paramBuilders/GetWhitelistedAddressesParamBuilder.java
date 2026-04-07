package exchange.notbank.wallet.paramBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class GetWhitelistedAddressesParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;

  public GetWhitelistedAddressesParamBuilder(Integer accountId) {
    this(accountId.toString());
  }

  public GetWhitelistedAddressesParamBuilder(String accountId) {
    this.httpConfiguration = new HttpConfiguration();
    this.params = new HashMap<>();
    this.params.put("account_id", accountId);
  }

  public GetWhitelistedAddressesParamBuilder search(String value) {
    this.params.put("search", value);
    return this;
  }

  public GetWhitelistedAddressesParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public GetWhitelistedAddressesParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public GetWhitelistedAddressesParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
