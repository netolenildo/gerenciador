package br.com.gerenciador.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VeiculoDTO {

    private Long id;

    private String placa;

}
