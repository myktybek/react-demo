package com.pokemon.api.pockemon;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public List<Pokemon> find() {
        log.info("retrieving all pokemons");
        return repository.findAllByOrderByIdAsc();
    }

    public Pokemon create(Pokemon pokemon) {
        log.info("creating pokemon");
        return repository.save(pokemon);
    }

    public Pokemon update(Long id, int quantity) {
        log.info("updating pokemon");
        return repository.findById(id)
                .map(existingPokemon -> {
                    existingPokemon.setQuantity(quantity);
                    return repository.save(existingPokemon);
                })
                .orElse(null);
    }

    public void delete(Long id) {
        log.warn("deleting pokemon");
        repository.deleteById(id);
    }
}