package br.com.gerenciador.movimentacao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TipoMovimentacao {
    ENTRADA("ENTRADA"),
    SAIDA("SAIDA");

    private final String descricao;
}
