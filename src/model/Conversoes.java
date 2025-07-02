package model;

import java.util.Map;

public record Conversoes(Map<String, Double> conversion_rates) {

    public double getCotacao(String moedaDestino) {
        Double cotacao = conversion_rates.get(moedaDestino);
        if (cotacao == null) {
            throw new IllegalArgumentException("Moeda não suportada: " + moedaDestino);
        }
        return cotacao;
    }
}



