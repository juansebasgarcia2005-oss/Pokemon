package com.pokemon.controller;

import com.pokemon.dto.PokemonResponseDTO;
import com.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/{tipo}")
    public ResponseEntity<List<PokemonResponseDTO>> getPokemonsByTipo(@PathVariable("tipo") String tipo) {
        List<PokemonResponseDTO> response = pokemonService.getPokemonsByTipoUuid(tipo);
        return ResponseEntity.ok(response);
    }
}
