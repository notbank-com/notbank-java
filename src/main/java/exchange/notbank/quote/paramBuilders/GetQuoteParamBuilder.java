package exchange.notbank.quote.paramBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class GetQuoteParamBuilder implements ParamBuilder {
  private final Map<String, Object> params;
  private HttpConfiguration httpConfiguration;
  public final UUID quoteId;

  public GetQuoteParamBuilder(UUID quoteId) {
    this.httpConfiguration = HttpConfiguration.empty();
    this.params = new HashMap<>();
    this.quoteId = quoteId;
  }

  public GetQuoteParamBuilder userId(UUID userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public GetQuoteParamBuilder userId(String userId) {
      this.params.put("user_id", userId);
      return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public GetQuoteParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
