package exchange.notbank.users.constants;

public enum IdentityType {
  DNI(1),
  EXTRANJERO(2),
  NUIP(3),
  NIP(4),
  PEP(5),
  CC(6),
  CE(7),
  PASAPORTE(8);

  public final Integer value;

  IdentityType(Integer value) {
    this.value = value;
  }
}
