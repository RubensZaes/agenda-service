package com.rubenszaes.agenda.api.controller;

import com.rubenszaes.agenda.api.dto.AutenticacaoDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO autenticacaoDTO) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(autenticacaoDTO.usuario(), autenticacaoDTO.senha());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        return ResponseEntity.ok().build();
    }
}
