package exchange.notbank.quote.paramBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class ExecuteQuoteParamBuilder implements ParamBuilder {
  private final Map<String, Object> params;
  private HttpConfiguration httpConfiguration;
  public final UUID quoteId;

  public ExecuteQuoteParamBuilder(UUID quoteId) {
    this.httpConfiguration = HttpConfiguration.empty();
    this.params = new HashMap<>();
    this.quoteId = quoteId;
  }

  public ExecuteQuoteParamBuilder accountId(Integer accountId){
    this.params.put("account_id", accountId);
    return this;
  }

  public ExecuteQuoteParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public ExecuteQuoteParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public ExecuteQuoteParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
