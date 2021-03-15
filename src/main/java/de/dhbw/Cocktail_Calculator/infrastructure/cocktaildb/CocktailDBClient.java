package de.dhbw.Cocktail_Calculator.infrastructure.cocktaildb;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CocktailDBClient {

    public CocktailDbResponse getData(String cocktailName) {

        String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php";


        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("s", cocktailName);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CocktailDbResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, CocktailDbResponse.class);

        return response.getBody();
    }
}
