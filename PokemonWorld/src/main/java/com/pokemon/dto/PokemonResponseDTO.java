package com.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonResponseDTO {

    private String id;

    private String nombre;

    @JsonProperty("descripción")
    private String descripcion;

    @JsonProperty("fecha_descubrimiento")
    private String fechaDescubrimiento;

    @JsonProperty("generación")
    private String generacion;

    private String uuid;

    @JsonProperty("tipo_pokemon")
    private TipoPokemonDTO tipoPokemon;
}
