package br.com.gerenciador.veiculo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VeiculoForm {

    @NotBlank
    private String placa;

}
