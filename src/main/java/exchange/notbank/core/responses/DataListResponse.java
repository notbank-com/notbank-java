package exchange.notbank.core.responses;

import java.util.List;

public class DataListResponse {
    public final List<Object> data;
    public final int total;

    public DataListResponse(List<Object> data, Integer total) {
        this.data = data;
        this.total = total;
    }
}
