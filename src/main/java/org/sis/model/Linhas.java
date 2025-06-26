package org.sis.model;

public class Linhas {
    
    int idLinha;

    String nomeLinha;

    public static final Linhas Linha1 = new Linhas(1, "UFSM - Faixa-Nova - Bombeiros");
    public static final Linhas Linha2 = new Linhas(2, "UFSM - Faixa-Velha - Bombeiros");
    public static final Linhas Linha3 = new Linhas(3, "UFSM - Faixa-Nova");
    public static final Linhas Linha4 = new Linhas(4, "UFSM - Faixa-Velha");
    public static final Linhas Linha5 = new Linhas(5, "T.Neves - Campus");
    public static final Linhas Linha6 = new Linhas(6, "7 DE DEZEMBRO - ALTO DA BOA VISTA");
    public static final Linhas Linha7 = new Linhas(7, "ATE SEMINARIO SAO JOSE HORARIOS CORRIDOS");
    public static final Linhas Linha8 = new Linhas(8, "BOCA DO MONTE");
    public static final Linhas Linha9 = new Linhas(9, "SELECIONE A LINHA");
    public static final Linhas Linha10 = new Linhas(10, "CAMOBI-CARLOS GOMES-CFFERRARI");
    public static final Linhas Linha11 = new Linhas(11, "CAMPESTRE");
    public static final Linhas Linha12 = new Linhas(12, "CAPIVARA");
    public static final Linhas Linha13 = new Linhas(13, "CAROLINA - SAO JOSE");
    public static final Linhas Linha14 = new Linhas(14, "CASA DE SAUDE");
    public static final Linhas Linha15 = new Linhas(15, "CIRCULAR SUL -SAIDA CEMITERIO MUNICIPAL");
    public static final Linhas Linha16 = new Linhas(16, "CIRCULAR T NEVES");
    public static final Linhas Linha17 = new Linhas(17, "HORARIOS CLUBE DORES VIA FAIXA NOVA- JARDIM BERLEZE");
    public static final Linhas Linha18 = new Linhas(18, "HORARIOS VIA FAIXA NOVA");
    public static final Linhas Linha19 = new Linhas(19, "ITARARE BRIGADA - BRIGADA ITARARE");
    public static final Linhas Linha20 = new Linhas(20, "JARDIM BERLEZE - MARINGA- VIA ZILDA ARNS");
    public static final Linhas Linha21 = new Linhas(21, "MEDIANEIRA VIA CARLOS HUR");
    public static final Linhas Linha22 = new Linhas(22, "NORTE - SALGADO FILHO - GENTIL DALLALANA - CATURRITA - CONCEICAO - BELA UNIAO - SANTA TEREZINHA - VITORIA");
    public static final Linhas Linha23 = new Linhas(23, "PARQUE PINHEIRO MACHADO");
    public static final Linhas Linha24 = new Linhas(24, "PARQUE RIACHUELO");
    public static final Linhas Linha25 = new Linhas(25, "PASSO DAS TROPAS - MINUANO");
    public static final Linhas Linha26 = new Linhas(26, "PATRONATO");
    public static final Linhas Linha27 = new Linhas(27, "PAU A PIQUE");
    public static final Linhas Linha28 = new Linhas(28, "PRADO");
    public static final Linhas Linha29 = new Linhas(29, "SANTA MARTA");
    public static final Linhas Linha30 = new Linhas(30, "SANTOS - URLANDIA");
    public static final Linhas Linha31 = new Linhas(31, "SAO JOAO - KM2 - FORUM");
    public static final Linhas Linha32 = new Linhas(32, "T NEVES RODOVIARIA");
    public static final Linhas Linha33 = new Linhas(33, "TANCREDO NEVES");
    public static final Linhas Linha34 = new Linhas(34, "UFSM CIRCULAR");
    public static final Linhas Linha35 = new Linhas(35, "VILA LORENZI");
    public static final Linhas Linha36 = new Linhas(36, "VILA OLIVEIRA - CHACARA DAS FLORES");
    public static final Linhas Linha37 = new Linhas(37, "VILA ROSSI - BOI MORTO");
    public static final Linhas Linha38 = new Linhas(38, "VILA SCHIRMER-CAMPESTRE");

    public Linhas(int idLinha, String nomeLinha) {
        this.idLinha = idLinha;
        this.nomeLinha = nomeLinha;
    }

    public int getIdLinha() {
        return idLinha;
    }

    public void setIdLinha(int idLinha) {
        this.idLinha = idLinha;
    }

    public String getNomeLinha() {
        return nomeLinha;
    }

    public void setNomeLinha(String nomeLinha) {
        this.nomeLinha = nomeLinha;
    }
}
