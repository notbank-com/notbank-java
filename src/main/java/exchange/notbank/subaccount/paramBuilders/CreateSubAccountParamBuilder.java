package exchange.notbank.subaccount.paramBuilders;

import exchange.notbank.core.HttpConfiguration;
import exchange.notbank.core.NotbankException;
import exchange.notbank.core.ParamBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class CreateSubAccountParamBuilder implements ParamBuilder {

    private final Map<String, Object> params;
    private HttpConfiguration httpConfiguration;

    public CreateSubAccountParamBuilder(String alias) {
        this.httpConfiguration = HttpConfiguration.empty();
        this.params = new HashMap<>();
        this.params.put("alias", alias);
    }

    public CreateSubAccountParamBuilder userId(UUID userId) {
        this.params.put("user_id", userId);
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public HttpConfiguration getHttpConfiguration() {
        return httpConfiguration;
    }

    public CreateSubAccountParamBuilder setHttpConfiguration(
            HttpConfiguration httpConfiguration) {
        this.httpConfiguration = httpConfiguration;
        return this;
    }
}
