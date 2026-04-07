package exchange.notbank.wallet.constants;

public enum TransactionType {
  OTHER(0),
  DEPOSIT(1),
  WITHDRAW(2),
  TRANSFER(3),
  TRADE(4),
  PAYMENT(5),
  RECTIFICATION(6),
  FEE(7),
  REVERSE(8),
  HOLD(9),
  MARGIN(10),
  AIRDROP(11),
  DISTRIBUTION(12),
  MIGRATION(13);

  public final Integer value;

  TransactionType(Integer value) {
    this.value = value;
  }
}
