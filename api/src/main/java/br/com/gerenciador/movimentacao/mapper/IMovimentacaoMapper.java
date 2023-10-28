package br.com.gerenciador.movimentacao.mapper;

import br.com.gerenciador.movimentacao.Movimentacao;
import br.com.gerenciador.movimentacao.dto.MovimentacaoDTO;
import br.com.gerenciador.movimentacao.dto.MovimentacaoForm;

public interface IMovimentacaoMapper {

    Movimentacao toModel(MovimentacaoForm movimentacaoForm);

    MovimentacaoDTO fromModel(Movimentacao movimentacao);
}
