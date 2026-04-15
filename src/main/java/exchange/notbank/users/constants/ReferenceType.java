package exchange.notbank.users.constants;

import com.squareup.moshi.Json;

public enum ReferenceType {
  @Json(name = "Trade")
  TRADE,
  @Json(name = "Deposit")
  DEPOSIT,
  @Json(name = "Withdraw")
  WITHDRAW,
  @Json(name = "Transfer")
  TRANSFER,
  @Json(name = "OrderHold")
  ORDER_HOLD,
  @Json(name = "WithdrawHold")
  WITHDRAW_HOLD,
  @Json(name = "DepositHold")
  DEPOSIT_HOLD,
  @Json(name = "MarginHold")
  MARGIN_HOLD,
  @Json(name = "ManualHold")
  MANUAL_HOLD,
  @Json(name = "ManualEntry")
  MANUAL_ENTRY,
  @Json(name = "MarginAcquisition")
  MARGIN_ACQUISITION,
  @Json(name = "MarginRelinquish")
  MARGIN_RELINQUISH,
  @Json(name = "MarginQuoteHold")
  MARGIN_QUOTEHOLD,
  @Json(name = "MarginInterestNetting")
  MARGIN_INTEREST_NETTING,
  @Json(name = "MarginOperatorTransferToMarginAccount")
  MARGIN_OPERATOR_TRANSFER_TO_MARGIN_ACCOUNT,
  @Json(name = "MarginOperatorTransferToAssetAccount")
  MARGIN_OPERATOR_TRANSFER_TO_ASSET_ACCOUNT,
  @Json(name = "MarginUserTransfer")
  MARGIN_USER_TRANSFER,
  @Json(name = "MarginPositionReverseTrade")
  MARGIN_POSITION_REVERSE_TRADE,
  @Json(name = "AffiliateRebate")
  AFFILIATE_REBATE,
  @Json(name = "DistributionEntry")
  DISTRIBUTION_ENTRY,
  @Json(name = "TransferHold")
  TRANSFER_HOLD,
  @Json(name = "AirDrop")
  AIR_DROP;
}
