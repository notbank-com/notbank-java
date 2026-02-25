package exchange.notbank.core.responses;

public class AuthErrorResponse {
  public final String detail;

  public AuthErrorResponse(String detail) {
    this.detail = detail;
  }
}
