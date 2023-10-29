package br.com.gerenciador.usuario.dto;

import br.com.gerenciador.veiculo.dto.VeiculoDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class UsuarioDTO {

    private Long id;

    private String login;

    private String nome;

    private String email;

    private Set<VeiculoDTO> veiculos;
}
