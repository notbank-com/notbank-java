package exchange.notbank.quote.paramBuilders;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;
import exchange.notbank.quote.constants.QuoteOperation;

public class CreateDirectQuoteParamBuilder implements ParamBuilder {
  private final Map<String, Object> params;
  private HttpConfiguration httpConfiguration;

  public CreateDirectQuoteParamBuilder(Integer accountId, String fromCurrency, BigDecimal fromAmount, String toCurrency, QuoteOperation operation) {
    this.httpConfiguration = HttpConfiguration.empty();
    this.params = new HashMap<>();
    this.params.put("account_id", accountId);
    this.params.put("from_currency", fromCurrency);
    this.params.put("from_amount", fromAmount);
    this.params.put(("to_currency"), toCurrency);
    this.params.put("operation", operation.value);
  }

  public CreateDirectQuoteParamBuilder(String fromCurrency, BigDecimal fromAmount, String toCurrency, QuoteOperation operation) {
    this.httpConfiguration = HttpConfiguration.empty();
    this.params = new HashMap<>();
    this.params.put("from_currency", fromCurrency);
    this.params.put("from_amount", fromAmount);
    this.params.put(("to_currency"), toCurrency);
    this.params.put("operation", operation.value);
  }

  public CreateDirectQuoteParamBuilder accountId(Integer accountId){
    this.params.put("account_id", accountId);
    return this;
  }

  public CreateDirectQuoteParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public CreateDirectQuoteParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public CreateDirectQuoteParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
