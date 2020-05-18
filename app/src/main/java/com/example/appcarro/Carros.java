package com.example.appcarro;

public class Carros {

    private String nome;
    private String placa;
    private String ano;
    private String valor;
    private String data;
    private String descricao;

    public Carros(String nome, String placa, String ano, String valor, String data, String descricao) {
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public Carros(){

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
