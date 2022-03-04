# Pokedex
```
 API de pokedex básica usando Spring web reactive e mongodb reactive.
```

# Pré-Requisitos

### Maven
### Java 17

# Executar

### ----
### ----

# Postman

### Cadastrar Pokémon.
````
 POST localhost:8080/pokemons
 {
    "nomePokemon": " ",
    "categoria": " ",
    "habilidades": " ",
    "peso": " ",
    "descricao": " ",
    "genero": " "
}
````
### Consultar todos os pokémons cadastrados.
````
GET localhost:8080/pokemons
````

### Consultar pokémon por ID
````
GET localhost:8080/pokemons/{id}
````

#### Deletar pokémon por ID
````
DELETE localhost:8080/pokemons/{id}
````

### Deletar todos os pokémons cadastrados
````
DELETE localhost:8080/pokemons
````
