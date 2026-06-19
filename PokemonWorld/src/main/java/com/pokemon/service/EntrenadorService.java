package com.pokemon.service;

import com.pokemon.dto.LoginRequestDTO;
import com.pokemon.dto.LoginResponseDTO;
import com.pokemon.exception.ResourceNotFoundException;
import com.pokemon.model.Entrenador;
import com.pokemon.repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public LoginResponseDTO login(LoginRequestDTO request) {
        Entrenador entrenador = entrenadorRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Entrenador no encontrado con el email: " + request.getEmail()));
                
        return new LoginResponseDTO(entrenador.getUuid());
    }
}
