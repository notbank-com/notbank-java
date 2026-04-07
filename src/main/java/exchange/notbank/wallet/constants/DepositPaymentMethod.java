package exchange.notbank.wallet.constants;

public enum DepositPaymentMethod {
  BANK_TRANSFER(1),
  SHINKANSEN(1),
  POWWI(1),
  KUSHKY_WEBPAY(2),
  GMONEY_CCI(3),
  GMONEY_QR(4),
  KHIPU(5),
  KUSHKY_WEBCHECKOUT(6),
  SAFETYPAY(7),
  VPAY_QR(8);

  public final Integer value;

  DepositPaymentMethod(Integer value) {
    this.value = value;
  }
}
