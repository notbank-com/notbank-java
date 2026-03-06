package exchange.notbank.quote.constants;

public enum QuoteState {
  CREATED(-1),
  PENDING(0),
  EXECUTED(1),
  INSUFFICIENT_BALANCE(3),
  NOT_EXECUTED(4),
  OTHER(5),
  EXPIRED(6),
  EXCEED_DAILY_TRANSFER_LIMIT(7),
  EXCEED_MONTHLY_TRANSFER_LIMIT(8),
  EXCEED_YEARLY_TRANSFER_LIMIT(9);

  public final Integer value;

  QuoteState(Integer value) {
    this.value = value;
  }
}
