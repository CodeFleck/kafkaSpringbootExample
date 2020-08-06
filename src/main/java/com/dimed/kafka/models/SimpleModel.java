package com.dimed.kafka.models;

import org.springframework.stereotype.Component;

@Component
public class SimpleModel {

    private String identificadorTransacao;

    public SimpleModel() {
    }

    public SimpleModel(String identificadorTransacao) {
        this.identificadorTransacao = identificadorTransacao;
    }

    public String getIdentificadorTransacao() {
        return identificadorTransacao;
    }

    public void setIdentificadorTransacao(String identificadorTransacao) {
        this.identificadorTransacao = identificadorTransacao;
    }

    @Override
    public String toString() {
        return "SimpleModel{" +
                "identificadorTransacao='" + identificadorTransacao + '\'' +
                '}';
    }
}
