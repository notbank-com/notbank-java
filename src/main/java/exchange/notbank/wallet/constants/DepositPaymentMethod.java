package exchange.notbank.wallet.constants;

public enum DepositPaymentMethod {
  BANK_TRANSFER(1),
  WEBPAY(2),
  VIRTUAL_WALLET(3),
  QR_CODE(4),
  ASSISTED_BANK_TRANSFER(5),
  CREDIT_DEBIT_CARD(6),
  CASH_OR_CARD(7),
  QR_IMAGE(8);


  public final Integer value;

  DepositPaymentMethod(Integer value) {
    this.value = value;
  }
}
