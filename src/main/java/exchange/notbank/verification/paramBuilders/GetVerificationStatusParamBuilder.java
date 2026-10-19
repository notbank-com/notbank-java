package exchange.notbank.verification.paramBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class GetVerificationStatusParamBuilder implements ParamBuilder {
  private final Map<String, Object> params;
  private HttpConfiguration httpConfiguration;

  public GetVerificationStatusParamBuilder() {
    this.httpConfiguration = HttpConfiguration.empty();
    this.params = new HashMap<>();
  }

  public GetVerificationStatusParamBuilder userId(UUID userId) {
    this.params.put("user_id", userId);
    return this;
  }

  public GetVerificationStatusParamBuilder userId(String userId) {
    this.params.put("user_id", userId);
    return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public GetVerificationStatusParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
