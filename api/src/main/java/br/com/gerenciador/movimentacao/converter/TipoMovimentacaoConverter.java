package br.com.gerenciador.movimentacao.converter;

import br.com.gerenciador.movimentacao.ETipoMovimentacao;
import jakarta.persistence.AttributeConverter;

public class TipoMovimentacaoConverter implements AttributeConverter<ETipoMovimentacao, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ETipoMovimentacao tipoMovimentacao) {
        return tipoMovimentacao.getValor();
    }

    @Override
    public ETipoMovimentacao convertToEntityAttribute(Integer valor) {
        return ETipoMovimentacao.getTipoMovimentacao(valor);
    }
}
