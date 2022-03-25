package com.tsdroiddevelop.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class InfoBanco {

    private String nome;
    private Integer cnpj;
    private String dataCriacao;
    private String codigo;

    public InfoBanco() {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Random random = new Random();
        this.nome = "BancoTS";
        this.cnpj = random.nextInt(14);
        this.dataCriacao = data;
        this.codigo = "0001";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
