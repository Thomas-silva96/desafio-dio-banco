package com.tsdroiddevelop.model;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Cartao {

    private Integer numeroCartao;
    private String validade;
    private Integer codigoSeguranca;

    public Cartao() throws ParseException {
        String data = LocalDateTime.now().plusYears(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Random random = new Random();

        this.numeroCartao = random.nextInt(16);
        this.codigoSeguranca = random.nextInt(3);
        this.validade = data;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Integer getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(Integer codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

}