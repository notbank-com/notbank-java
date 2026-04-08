package exchange.notbank.yield.paramBuilders;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class DepositToYieldParamBuilder implements ParamBuilder {
  protected final Map<String, Object> params;
  protected HttpConfiguration httpConfiguration;

  public DepositToYieldParamBuilder(Integer accountId,  String currency, Integer productId, String type,
      BigDecimal amount) {
    this(accountId.toString(), currency,productId, type, amount);
  }

  public DepositToYieldParamBuilder(String accountId, String currency, Integer productId, String type,
      BigDecimal amount) {
    this.httpConfiguration = new HttpConfiguration();
    this.params = new HashMap<>();
    this.params.put("account_id", accountId);
    this.params.put("amount", amount.toPlainString());
    this.params.put("product_id", productId);
    this.params.put("currency", currency);
    this.params.put("type", type);
  }

  public DepositToYieldParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public DepositToYieldParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public DepositToYieldParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
