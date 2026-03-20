package com.example.pokemon_service.service;

import com.example.pokemon_service.model.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MainService {

    private final WebClient webClient;

    public MainService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://pokeapi.co/api/v2").build();
    }

    public Pokemon getPokemonDetails(String name) {
        return webClient.get()
                .uri("/pokemon/{name}", name)
                .retrieve()
                .bodyToMono(Pokemon.class)
                .block();
    }
}