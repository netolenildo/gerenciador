package br.com.gerenciador.autorizacao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum EPapel {
    ADMIN(1),
    COMUM(2);

    private final Integer valor;

    public static String getPapel(Integer valor) {
        return Stream.of(EPapel.values()).filter(p -> p.getValor().equals(valor)).map(Enum::name).findFirst().orElse("");
    }
}
