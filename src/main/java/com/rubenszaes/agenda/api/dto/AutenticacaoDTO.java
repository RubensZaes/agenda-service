package com.rubenszaes.agenda.api.dto;

import com.rubenszaes.agenda.domain.model.Usuario;

public record AutenticacaoDTO(
        String usuario,
        String senha
) {
//    public AutenticacaoDTO(Usuario usuario) {
//        this(usuario.getUsuario(), usuario.getSenha());
//    }
}
