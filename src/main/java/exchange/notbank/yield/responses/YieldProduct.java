package exchange.notbank.yield.responses;

import com.squareup.moshi.Json;

public class YieldProduct {
  @Json(name = "product_title")
  public final String productTitle;
  @Json(name = "product_id")
  public final Integer productId;
  public final String description;
  @Json(name= "min_yield_time")
  public final String minYieldTime;
  public final String type;
  @Json(name = "last_change")
  public final Double lastChange;

  public YieldProduct(String productTitle, Integer productId,
    String description, String minYieldTime, String type,
    Double lastChange
  ) {
    this.productTitle = productTitle;
    this.productId = productId;
    this.description = description;
    this.minYieldTime = minYieldTime;
    this.type = type;
    this.lastChange = lastChange;
  }

  @Override
  public String toString() {
    return "YieldProduct [productTitle=" + productTitle + ", productId=" + productId +
    ", description=" + description + ", minYieldTime=" + minYieldTime + ", type=" + type +
    ", lastChange=" + lastChange + "]";
  }
}
