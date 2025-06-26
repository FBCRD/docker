package org.sis.model;

public class Cartao {
    private int id_cartao;
    private String nome_cartao;
    private GrupoCartao grupoCartao;
    private Usuario usuario;
    private float Saldo;
    public Cartao() {
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id_cartao=" + id_cartao +
                ", nome_cartao='" + nome_cartao + '\'' +
                ", grupoCartao=" + grupoCartao +
                ", usuario=" + usuario +
                ", Saldo=" + Saldo +
                '}';
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setSaldo(float saldo) {
        Saldo = saldo;
    }

    public GrupoCartao getGrupoCartao() {
        return grupoCartao;
    }

    public void setGrupoCartao(GrupoCartao grupoCartao) {
        this.grupoCartao = grupoCartao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cartao(int id_cartao, String nome_cartao, float saldo) {
        this.id_cartao = id_cartao;
        this.nome_cartao = nome_cartao;
        Saldo = saldo;
    }

    public Cartao(String nome_cartao, GrupoCartao grupoCartao, Usuario usuario, float saldo) {

        this.nome_cartao = nome_cartao;
        this.grupoCartao = grupoCartao;
        this.usuario = usuario;
        Saldo = saldo;
    }

    public int getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(int id_cartao) {
        this.id_cartao = id_cartao;
    }

    public String getNome_cartao() {
        return nome_cartao;
    }

    public void setNome_cartao(String nome_cartao) {
        this.nome_cartao = nome_cartao;
    }
}
