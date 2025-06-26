package org.sis.model;

public class GrupoCartao {
    private int id_grupo_cartao;
    private String nome_grupo;
    private boolean gratuito;

    public static final GrupoCartao GRUPO_1 = new GrupoCartao(1, "Idoso", true);
    public static final GrupoCartao GRUPO_2 = new GrupoCartao(2, "Estudante", false);
    public static final GrupoCartao GRUPO_3 = new GrupoCartao(3, "Empresa", false);
    public static final GrupoCartao GRUPO_4 = new GrupoCartao(4, "Cidadao", false);
    public static final GrupoCartao GRUPO_5 = new GrupoCartao(5, "Operario", false);




    public GrupoCartao() {

    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public int getId_grupo_cartao() {
        return id_grupo_cartao;
    }

    public GrupoCartao(int id_grupo_cartao, String nome_grupo, boolean gratuito) {
        this.id_grupo_cartao = id_grupo_cartao;
        this.nome_grupo = nome_grupo;
        this.gratuito = gratuito;
    }

    public GrupoCartao(int id_grupo_cartao, String nome_grupo) {
        this.id_grupo_cartao = id_grupo_cartao;
        this.nome_grupo = nome_grupo;
    }

    public void setId_grupo_cartao(int id_grupo_cartao) {
        this.id_grupo_cartao = id_grupo_cartao;
    }

    public String getNome_grupo() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo = nome_grupo;
    }
}
