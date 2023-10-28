package br.com.gerenciador.movimentacao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum ETipoMovimentacao {
    ENTRADA(1),
    SAIDA(-1);

    private final Integer valor;

    public static ETipoMovimentacao getTipoMovimentacao(Integer valor) {
        return Stream.of(ETipoMovimentacao.values()).filter(t -> t.getValor().equals(valor)).findFirst().orElse(null);
    }

}
