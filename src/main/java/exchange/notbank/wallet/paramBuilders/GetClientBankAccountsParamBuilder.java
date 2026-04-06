package exchange.notbank.wallet.paramBuilders;

import java.util.HashMap;
import java.util.Map;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class GetClientBankAccountsParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;

  public GetClientBankAccountsParamBuilder() {
    this.httpConfiguration = new HttpConfiguration();
    this.params = new HashMap<>();

  }

  public GetClientBankAccountsParamBuilder page(Integer value) {
    this.params.put("page", value);
    return this;
  }

  public GetClientBankAccountsParamBuilder pageSize(Integer value) {
    this.params.put("page_size", value);
    return this;
  }

  public GetClientBankAccountsParamBuilder accountId(Integer accountId){
    this.params.put("account_id", userId);
    return this;
  }

  public GetClientBankAccountsParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public GetClientBankAccountsParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public GetClientBankAccountsParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
