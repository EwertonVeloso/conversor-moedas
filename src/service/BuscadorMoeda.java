package service;

import com.google.gson.*;
import model.Conversoes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class BuscadorMoeda {

    public Conversoes converte (String moeda) {

        String apikey = "cc435d55b49cf5bb9ff253cb";
        String endereco = "https://v6.exchangerate-api.com/v6/" + apikey + "/latest/" + moeda;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();

            String json = response.body();

            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
            JsonObject cotacoes = jsonObject.getAsJsonObject("conversion_rates");

            Map<String, Double> mapa = gson.fromJson(cotacoes, Map.class);

            return new Conversoes(mapa);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao fazer a busca pelas cotações");
        }
    }

}
