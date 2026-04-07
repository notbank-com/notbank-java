package exchange.notbank.wallet.paramBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;
import exchange.notbank.wallet.constants.BankAccountKind;

public class AddClientBankAccountParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;

  public AddClientBankAccountParamBuilder(String country, String bank, String number, BankAccountKind kind) {
    this.httpConfiguration = new HttpConfiguration();
    this.params = new HashMap<>();
    this.params.put("country", country);
    this.params.put("bank", bank);
    this.params.put("number", number);
    this.params.put("kind", kind);
  }

  public AddClientBankAccountParamBuilder pixType(String value) {
    this.params.put("pix_type", value);
    return this;
  }

  public AddClientBankAccountParamBuilder agency(String value) {
    this.params.put("agency", value);
    return this;
  }

  public AddClientBankAccountParamBuilder dv(String value) {
    this.params.put("dv", value);
    return this;
  }

  public AddClientBankAccountParamBuilder province(String value) {
    this.params.put("province", value);
    return this;
  }

  public AddClientBankAccountParamBuilder accountId(Integer accountId){
    this.params.put("account_id", accountId);
    return this;
  }

  public AddClientBankAccountParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public AddClientBankAccountParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public AddClientBankAccountParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
