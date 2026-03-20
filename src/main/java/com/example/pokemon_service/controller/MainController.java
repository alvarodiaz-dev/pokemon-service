package com.example.pokemon_service.controller;

import com.example.pokemon_service.model.Pokemon;
import com.example.pokemon_service.service.MainService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/pokemon/{name}")
    public Pokemon getPokemonDetails(@PathVariable String name) {
        return mainService.getPokemonDetails(name);
    }
}