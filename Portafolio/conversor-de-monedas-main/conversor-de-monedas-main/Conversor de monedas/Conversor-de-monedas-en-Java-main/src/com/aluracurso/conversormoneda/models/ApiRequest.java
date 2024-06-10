
package com.aluracurso.conversormoneda.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    public Currency getDataApi(String baseCode){
        //String baseUrl = "https://v6.exchangerate-api.com/v6/aad9e69862c46f6f2f9dbaee/pair/"+baseCode+"/"+targetCode+"/"+amount;

        String baseUrl = "https://v6.exchangerate-api.com/v6/aad9e69862c46f6f2f9dbaee/latest/"+baseCode;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .build();
        try{
            HttpResponse <String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Currency.class);
            } catch (IOException | InterruptedException  e) {
                throw new RuntimeException(e);
            }

        }
    }
