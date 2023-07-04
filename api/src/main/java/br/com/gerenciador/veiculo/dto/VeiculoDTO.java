package br.com.gerenciador.veiculo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VeiculoDTO {

    private Long id;

    private String placa;

}
