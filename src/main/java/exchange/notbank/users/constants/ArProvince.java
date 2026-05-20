package exchange.notbank.users.constants;

public enum ArProvince {
  BUENOS_AIRES(1),
  SANTA_FE(2),
  CORDOBA(3),
  MENDOZA(4),
  ENTRE_RIOS(5),
  SANTIAGO_DEL_ESTERO(6),
  SAN_JUAN(7),
  SAN_LUIS(8),
  LA_RIOJA(9),
  CATAMARCA(10),
  JUJUY(11),
  SALTA(12),
  FORMOSA(13),
  CHACO(14),
  CORRIENTES(15),
  MISIONES(16),
  TUCUMAN(17),
  LA_PAMPA(18),
  NEUQUEN(19),
  CHUBUT(20),
  RIO_NEGRO(21),
  SANTA_CRUZ(22),
  TIERRA_DEL_FUEGO(23),
  CIUDAD_AUTONOMA_DE_BUENOS_AIRES(43);

  public final Integer value;

  ArProvince(Integer value) {
    this.value = value;
  }
}
