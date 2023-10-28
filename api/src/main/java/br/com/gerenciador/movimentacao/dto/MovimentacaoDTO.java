package br.com.gerenciador.movimentacao.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MovimentacaoDTO {

    private Long id;

    private String descricao;

    private LocalDate data;

    private String tipoMovimentacao;

    private Double valor;
}
