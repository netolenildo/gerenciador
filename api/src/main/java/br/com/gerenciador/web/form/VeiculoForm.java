package br.com.gerenciador.web.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class VeiculoForm {

    @NotBlank
    private String placa;

}
