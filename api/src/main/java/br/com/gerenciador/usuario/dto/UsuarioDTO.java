package br.com.gerenciador.usuario.dto;

import br.com.gerenciador.veiculo.dto.VeiculoDTO;
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
