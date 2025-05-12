package cl.conversor.modelos;

import cl.conversor.Config;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public RespuestaApi obtenerDatos(String monedaUno, String monedaDos){
        Config config = new Config();

        String keyNumber = config.get("keynumber");

            try {
                String url = "https://v6.exchangerate-api.com/v6/" + keyNumber + "/pair/" + monedaUno + "/" + monedaDos;
                URI direccion = URI.create(url);

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(direccion)
                        .GET()
                        .build();

                HttpResponse<String> response;
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                return new  Gson().fromJson(response.body(), RespuestaApi.class);

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

}
