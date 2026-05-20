package exchange.notbank.users.constants;

public enum CivilStatus {
  SOLTERO("soltero"),
  CASADO("casado"),
  CONVIVIENTE("conviviente"),
  DIVORCIADO("divorciado"),
  VIUDO("viudo");

  public final String value;

  CivilStatus(String value) {
    this.value = value;
  }
}
