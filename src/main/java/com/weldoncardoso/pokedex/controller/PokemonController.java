package com.weldoncardoso.pokedex.controller;

import com.weldoncardoso.pokedex.model.Pokemon;
import com.weldoncardoso.pokedex.repository.PokemonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private PokemonRepository repository;

    public PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<Pokemon> getAllPokemons(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Pokemon>> getPokemon(@PathVariable String id){
        return repository.findById(id)
                .map(pokemon -> ResponseEntity.ok(pokemon))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Pokemon> savePokemon(@RequestBody Pokemon pokemon){
        return repository.save(pokemon);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<Pokemon>> updatePokemon(@PathVariable(value = "id") String id,
                                                       @RequestBody Pokemon pokemon){
        return repository.findById(id)
                .flatMap(existingPokemon -> {
                    existingPokemon.setNomePokemon(pokemon.getNomePokemon());
                    existingPokemon.setCategoria(pokemon.getCategoria());
                    existingPokemon.setHabilidades(pokemon.getHabilidades());
                    existingPokemon.setPeso(pokemon.getPeso());
                    existingPokemon.setDescricao(pokemon.getDescricao());
                    existingPokemon.setGenero(pokemon.getGenero());
                    return repository.save(existingPokemon);
                })
                .map(updatePokemon -> ResponseEntity.ok(updatePokemon))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<ResponseEntity<Void>> deletePokemon(@PathVariable(value = "id") String id) {
        return repository.findById(id)
                .flatMap(existingPokemon ->
                        repository.delete(existingPokemon)
                                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                )
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<Void> deleteAllPokemons(){
        return repository.deleteAll();
    }
}
