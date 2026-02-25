package exchange.notbank.core.responses;

public class NbErrorResponse {
  public final String status;
  public final String code;
  public final String message;

  public NbErrorResponse(String status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;

  }
}
