package com.weldoncardoso.pokedex.repository;

import com.weldoncardoso.pokedex.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PokemonRepository extends ReactiveMongoRepository <Pokemon, String>{
}
