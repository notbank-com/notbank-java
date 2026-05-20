package exchange.notbank.users.responses;

import com.squareup.moshi.Json;

public class RegisterUserData {
  @Json(name = "userId")
  public final String userId;
  @Json(name = "token")
  public final String token;

  public RegisterUserData(String userId, String token) {
    this.userId = userId;
    this.token = token;
  }

  @Override
  public String toString() {
    return "RegisterUserData [userId=" + userId + ", token=" + token + "]";
  }
}
