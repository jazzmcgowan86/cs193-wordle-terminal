import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

//An API that allows the program to pull the official Wordle word of the day from the NYTimes.
//@Author Jazmine McGowan

public class WordleAPI {
    private final HttpClient client;
    private final ObjectMapper map;

    public WordleAPI() {
        client = HttpClient.newHttpClient();
        map = new ObjectMapper();
    }

    //Grabs the official word of the day from the nytimes site, throws two exceptions
    // if either the response did not return 200 OK status, the solution was empty, or
    // the solution isn't in the correct format
    public String getWordleOfTheDay() throws IOException, InterruptedException {
        LocalDate today = LocalDate.now();
        String date = today.toString();
        String apiURL = "https://www.nytimes.com/svc/wordle/v2/" + date + ".json";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiURL)).timeout(Duration.ofSeconds(30)).header("User-Agent", "Mozilla/5.0").GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Failed to retrieve Word of the Day");
        }

        JsonNode jsonResponse = map.readTree(response.body());
        JsonNode getSolution = jsonResponse.get("solution");

        if (getSolution == null || !getSolution.isTextual()) {
            throw new IOException("Word of the Day was not found.");
        }

        return getSolution.asText().toUpperCase();
    }
}
