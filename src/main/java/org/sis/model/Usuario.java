package org.sis.model;

import java.util.Date;

public class Usuario {
    private int id_usuario;
    private String nome_usuario;
    private String email;
    private String senha;
    private String data_nasc;
    private String endereco;
    private String telefone;
    private String cpf;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nome_usuario, String email, String senha, String data_nasc, String endereco, String telefone, String cpf) {
        this.id_usuario = id_usuario;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Usuario(String nome_usuario, String email, String senha, String data_nasc, String endereco, String telefone, String cpf) {
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.data_nasc = data_nasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
