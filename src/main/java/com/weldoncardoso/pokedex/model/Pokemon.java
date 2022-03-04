package com.weldoncardoso.pokedex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Pokemon {

    @Id
    private String id;

    private String nomePokemon;

    private String categoria;

    private String habilidades;

    private Double peso;

    private String descricao;

    private String genero;

    public Pokemon(){
        super();
    }

    public Pokemon(String id, String nomePokemon, String categoria, String habilidades, Double peso, String descricao, String genero) {
        this.id = id;
        this.nomePokemon = nomePokemon;
        this.categoria = categoria;
        this.habilidades = habilidades;
        this.peso = peso;
        this.descricao = descricao;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(getId(), pokemon.getId()) && Objects.equals(getNomePokemon(), pokemon.getNomePokemon()) && Objects.equals(getCategoria(), pokemon.getCategoria()) && Objects.equals(getHabilidades(), pokemon.getHabilidades()) && Objects.equals(getPeso(), pokemon.getPeso()) && Objects.equals(getDescricao(), pokemon.getDescricao()) && Objects.equals(getGenero(), pokemon.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNomePokemon(), getCategoria(), getHabilidades(), getPeso(), getDescricao(), getGenero());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                ", nomePokemon='" + nomePokemon + '\'' +
                ", categoria='" + categoria + '\'' +
                ", habilidades='" + habilidades + '\'' +
                ", peso=" + peso +
                ", descricao='" + descricao + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}

