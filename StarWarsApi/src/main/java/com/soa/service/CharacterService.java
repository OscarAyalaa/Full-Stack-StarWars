package com.soa.service;

import org.springframework.stereotype.Service;

import com.soa.client.SwapiClient;
import com.soa.dto.SwapiPeopleResponse;

@Service
public class CharacterService {
	
	private final SwapiClient swapiClient;
	
	public CharacterService(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    public SwapiPeopleResponse getCharacters(int page, String search) {
        return swapiClient.getPeople(page, search);
    }
}
