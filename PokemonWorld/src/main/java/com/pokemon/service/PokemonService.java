package com.pokemon.service;

import com.pokemon.dto.PokemonResponseDTO;
import com.pokemon.dto.TipoPokemonDTO;
import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    
    // El formato esperado es "yyyy/MM/dd" según el JSON de ejemplo
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public List<PokemonResponseDTO> getPokemonsByTipoUuid(String tipoUuid) {
        List<Pokemon> pokemons = pokemonRepository.findByTipoPokemonUuid(tipoUuid);

        return pokemons.stream().map(pokemon -> {
            TipoPokemonDTO tipoDto = null;
            if (pokemon.getTipoPokemon() != null) {
                tipoDto = new TipoPokemonDTO(
                        String.valueOf(pokemon.getTipoPokemon().getId()),
                        pokemon.getTipoPokemon().getDescripcion(),
                        pokemon.getTipoPokemon().getUuid()
                );
            }

            String formattedDate = pokemon.getFechaDescubrimiento() != null 
                ? pokemon.getFechaDescubrimiento().format(DATE_FORMATTER) 
                : null;

            return new PokemonResponseDTO(
                    String.valueOf(pokemon.getId()),
                    pokemon.getNombre(),
                    pokemon.getDescription(),
                    formattedDate,
                    String.valueOf(pokemon.getGeneracion()),
                    pokemon.getUuid(),
                    tipoDto
            );
        }).collect(Collectors.toList());
    }
}
