package exchange.notbank.users.constants;

public enum BrState {
  RONDONIA("RO"),
  ACRE("AC"),
  AMAZONAS("AM"),
  RORAIMA("RR"),
  PARA("PA"),
  AMAPA("AP"),
  TOCANTINS("TO"),
  MARANHAO("MA"),
  PIAUI("PI"),
  CEARA("CE"),
  RIO_GRANDE_DO_NORTE("RN"),
  PARAIBA("PB"),
  PERNAMBUCO("PE"),
  ALAGOAS("AL"),
  SERGIPE("SE"),
  BAHIA("BA"),
  MINAS_GERAIS("MG"),
  ESPIRITO_SANTO("ES"),
  RIO_DE_JANEIRO("RJ"),
  SAO_PAULO("SP"),
  PARANA("PR"),
  SANTA_CATARINA("SC"),
  RIO_GRANDE_DO_SUL("RS"),
  MATO_GROSSO_DO_SUL("MS"),
  MATO_GROSSO("MT"),
  GOIAS("GO"),
  DISTRITO_FEDERAL("DF");

  public final String value;

  BrState(String value) {
    this.value = value;
  }
}
