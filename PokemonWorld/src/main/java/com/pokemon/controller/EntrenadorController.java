package com.pokemon.controller;

import com.pokemon.dto.LoginRequestDTO;
import com.pokemon.dto.LoginResponseDTO;
import com.pokemon.service.EntrenadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrenador")
@RequiredArgsConstructor
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        LoginResponseDTO response = entrenadorService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
