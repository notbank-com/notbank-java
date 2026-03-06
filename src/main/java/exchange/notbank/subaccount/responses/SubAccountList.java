package exchange.notbank.subaccount.responses;

import com.squareup.moshi.Json;
import java.util.List;
import java.util.stream.Collectors;

import exchange.notbank.core.responses.DataListResponse;


public class SubAccountList {

    @Json(name = "data")
    public final List<SubAccountInfo> data;

    @Json(name = "total")
    public final Integer total;

    public SubAccountList(DataListResponse response) {
        // Fix: Actually populate the data list
        this.data = response.data.stream()
            .map(obj -> (SubAccountInfo) obj)
            .collect(Collectors.toList());
        this.total = response.total;
    }
}
