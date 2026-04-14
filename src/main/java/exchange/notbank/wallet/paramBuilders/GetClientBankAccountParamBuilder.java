package exchange.notbank.wallet.paramBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class GetClientBankAccountParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;
  private String bankAccountId;

  public GetClientBankAccountParamBuilder(String bankAccountId) {
    this.httpConfiguration = new HttpConfiguration();
    this.params = new HashMap<>();
    this.bankAccountId = bankAccountId;
  }

  public String getBankAccountId() {
    return bankAccountId;
  }


  public GetClientBankAccountParamBuilder accountId(Integer accountId){
    this.params.put("account_id", accountId);
    return this;
  }

  public GetClientBankAccountParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public GetClientBankAccountParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public GetClientBankAccountParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
