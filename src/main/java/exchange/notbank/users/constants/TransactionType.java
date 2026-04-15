package exchange.notbank.users.constants;

import com.squareup.moshi.Json;

public enum TransactionType {
  @Json(name = "Fee")
  FEE,
  @Json(name = "Trade")
  TRADE,
  @Json(name = "Other")
  OTHER,
  @Json(name = "Reverse")
  REVERSE,
  @Json(name = "Hold")
  HOLD,
  @Json(name = "Rebate")
  REBATE,
  @Json(name = "MarginAcquisition")
  MARGIN_ACQUISITION,
  @Json(name = "MarginRelinquish")
  MARGIN_RELINQUISH,
  @Json(name = "MarginRelinquishByTrade")
  MARGIN_RELINQUISH_BY_TRADE,
  @Json(name = "MarginInterestTransfer")
  MARGIN_INTEREST_TRANSFER,
  @Json(name = "MarginOperatorTransferToMarginAccount")
  MARGIN_OPERATOR_TRANSFER_TO_MARGIN_ACCOUNT,
  @Json(name = "MarginOperatorTransferToAssetAccount")
  MARGIN_OPERATOR_TRANSFER_TO_ASSET_ACCOUNT,
  @Json(name = "MarginUserTransfer")
  MARGIN_USER_TRANSFER,
  @Json(name = "MarginRelinquishByTransfer")
  MARGIN_RELINQUISH_BY_TRANSFER,
  @Json(name = "MarginRelinquishByReverseTrade")
  MARGIN_RELINQUISH_BY_REVERSE_TRADE,
  @Json(name = "Distribution")
  DISTRIBUTION,
  @Json(name = "Payment")
  PAYMENT,
  @Json(name = "OperatorLend")
  OPERATOR_LEND,
  @Json(name = "OperatorReceived")
  OPERATOR_RECEIVED,
  @Json(name = "Rebalance")
  REBALANCE,
  @Json(name = "Commission")
  COMMISSION,
  @Json(name = "AirDrop")
  AIR_DROP;
}
