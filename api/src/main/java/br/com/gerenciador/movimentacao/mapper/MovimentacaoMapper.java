package br.com.gerenciador.movimentacao.mapper;

import br.com.gerenciador.movimentacao.ETipoMovimentacao;
import br.com.gerenciador.movimentacao.Movimentacao;
import br.com.gerenciador.movimentacao.dto.MovimentacaoDTO;
import br.com.gerenciador.movimentacao.dto.MovimentacaoForm;
import br.com.gerenciador.veiculo.Veiculo;
import org.springframework.stereotype.Component;

@Component
public class MovimentacaoMapper implements IMovimentacaoMapper{
    @Override
    public Movimentacao toModel(MovimentacaoForm movimentacaoForm) {
        return Movimentacao.builder()
                .descricao(movimentacaoForm.getDescricao())
                .data(movimentacaoForm.getData())
                .valor(movimentacaoForm.getValor())
                .tipoMovimentacao(ETipoMovimentacao.getTipoMovimentacao(movimentacaoForm.getTipoMovimentacao()))
                .veiculo(Veiculo.builder().id(movimentacaoForm.getIdVeiculo()).build())
                .build();
    }

    @Override
    public MovimentacaoDTO fromModel(Movimentacao movimentacao) {
        return MovimentacaoDTO.builder()
                .descricao(movimentacao.getDescricao())
                .data(movimentacao.getData())
                .tipoMovimentacao(movimentacao.getTipoMovimentacao().name())
                .valor(movimentacao.getValor())
                .build();
    }
}
