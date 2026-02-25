package exchange.notbank.subaccount.responses;

import com.squareup.moshi.Json;

public class SubAccountInfo {
  @Json(name = "id")
  public final Integer id;
  @Json(name = "alias")
  public final String alias;
  @Json(name = "created_at")
  public final String createdAt;

  public SubAccountInfo(Integer id, String alias, String createdAt) {
    this.id = id;
    this.alias = alias;
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "SubAccountInfo [id=" + id + ", alias=" + alias + "createdAt" + createdAt + "]";
  }
}
