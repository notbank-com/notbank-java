package exchange.notbank.wallet.responses;

public class QrResponse {
  public final String qr;

  public QrResponse(String qr) {
    this.qr = qr;
  }

  @Override
  public String toString() {
    return "QrResponse [qr=" + qr + "]";
  }
}
