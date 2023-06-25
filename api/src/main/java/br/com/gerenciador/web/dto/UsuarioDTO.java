package br.com.gerenciador.web.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public class UsuarioDTO {

    private Long id;

    private String login;

    private String nome;

    private String email;

    private Set<VeiculoDTO> veiculos;
}
