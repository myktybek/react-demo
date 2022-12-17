package com.pokemon.api.pockemon;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/pokemon")
    public List<Pokemon> find() {
        return service.find();
    }

    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)
    public Pokemon create(@RequestBody Pokemon pokemon) {
        return service.create(pokemon);
    }

    @PutMapping("/pokemon/{id}")
    public Pokemon update(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        return service.update(id, (int) payload.get("quantity"));
    }

    @DeleteMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}