package com.soa.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.soa.dto.CharacterDto;
import com.soa.dto.SwapiPeopleResponse;

@Component
public class SwapiClient {
	
	private final RestClient restClient;

    public SwapiClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://swapi.dev/api")
                .build();
    }
    
    public SwapiPeopleResponse getPeople(int page, String search) {

    	SwapiPeopleResponse response;

        if (search != null && !search.isBlank()) {
            response = restClient
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/people/")
                            .queryParam("search", search)
                            .queryParam("page", page)
                            .build())
                    .retrieve()
                    .body(SwapiPeopleResponse.class);

        } else {
            response = restClient
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/people/")
                            .queryParam("page", page)
                            .build())
                    .retrieve()
                    .body(SwapiPeopleResponse.class);
        }

        response.getResults().forEach(character -> {

            String url = character.getUrl();

            if (url != null) {
                String id = url.replaceAll(".*/people/(\\d+)/?$", "$1");
                character.setId(Integer.valueOf(id));
            }
        });

        return response;
    }
    
    
    public CharacterDto getCharacterById(int id) {

        return restClient
                .get()
                .uri("/people/{id}/", id)
                .retrieve()
                .body(CharacterDto.class);
    }

}
