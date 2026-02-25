package exchange.notbank.subaccount.paramBuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.ParamBuilder;

public class GetSubAccountsParamBuilder implements ParamBuilder {
  private final Map<String, Object> params;
  private HttpConfiguration httpConfiguration;

  public GetSubAccountsParamBuilder() {
    this.httpConfiguration = HttpConfiguration.empty();
    this.params = new HashMap<>();
    this.params.put("page_size", 10);
    this.params.put("page", 1);
  }

  public GetSubAccountsParamBuilder userId(UUID userId) {
    this.params.put("user_id", userId);
    return this;
  }

  public GetSubAccountsParamBuilder page(Integer page) {
    this.params.put("page", page);
    return this;
  }

  public GetSubAccountsParamBuilder pageSize(Integer pageSize) {
    this.params.put("page_size", pageSize);
    return this;
  }

  public Map<String, Object> getParams() {
    return params;
  }

  public HttpConfiguration getHttpConfiguration() {
    return httpConfiguration;
  }

  public GetSubAccountsParamBuilder setHttpConfiguration(HttpConfiguration httpConfiguration) {
    this.httpConfiguration = httpConfiguration;
    return this;
  }
}
