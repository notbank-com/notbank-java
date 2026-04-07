package exchange.notbank.wallet.constants;

public enum TransactionSubType {
  OTHER(0),
  PAYOUT(1),
  PAYIN(2),
  DEPOSIT(3),
  WITHDRAW(4),
  BANK_TO_EXCHANGE(5),
  EXCHANGE_TO_BANK(6),
  TRADE(7),
  PAYMENT(8),
  SIMPLE(9),
  RECTIFICATION(10),
  TRANSFER(11),
  HOLD(12),
  MARGIN(13),
  AIRDROP(14),
  ORDER(15),
  DISTRIBUTION_ENTRY(16),
  MIGRATION(17),
  MANUAL_ENTRY(18);

  public final Integer value;

  TransactionSubType(Integer value) {
    this.value = value;
  }
}
