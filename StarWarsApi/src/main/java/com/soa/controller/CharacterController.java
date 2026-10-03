package com.soa.controller;

import com.soa.client.SwapiClient;
import com.soa.dto.CharacterDto;
import com.soa.dto.SwapiPeopleResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "http://localhost:4200/")
public class CharacterController {
	
	private final SwapiClient swapiClient;

    public CharacterController(SwapiClient swapiClient) { 
        this.swapiClient = swapiClient;
    }

    @GetMapping
    public SwapiPeopleResponse getCharacters(@RequestParam(defaultValue = "1") int page,
    										 @RequestParam(defaultValue = "") String search) {
        return swapiClient.getPeople(page, search);
    }
    
    @GetMapping("/{id}")
    public CharacterDto getCharacterById(@PathVariable int id) {

        return swapiClient.getCharacterById(id);
    }

}
