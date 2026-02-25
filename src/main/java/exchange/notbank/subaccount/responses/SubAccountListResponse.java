package exchange.notbank.subaccount.responses;
import com.squareup.moshi.Json;

public class SubAccountListResponse {

    @Json(name = "status")
    public final String status;

    @Json(name = "data")
    public final SubAccountList data;

    public SubAccountListResponse(String status, SubAccountList data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public SubAccountList getData() {
        return data;
    }
}
