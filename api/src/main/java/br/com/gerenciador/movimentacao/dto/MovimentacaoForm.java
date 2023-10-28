package br.com.gerenciador.movimentacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MovimentacaoForm {

    @NotBlank
    private String descricao;

    @NotNull
    private LocalDate data;

    @NotNull
    private Double valor;

    @NotNull
    private Integer tipoMovimentacao;

    @NotNull
    private Long idVeiculo;
}
