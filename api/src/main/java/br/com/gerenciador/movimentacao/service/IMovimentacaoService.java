package br.com.gerenciador.movimentacao.service;

import br.com.gerenciador.movimentacao.dto.MovimentacaoDTO;
import br.com.gerenciador.movimentacao.dto.MovimentacaoForm;

import java.time.LocalDate;
import java.util.List;

public interface IMovimentacaoService {

    void cadastrar(MovimentacaoForm movimentacaoForm);

    void remover(Long id);

    List<MovimentacaoDTO> filtrarMovimentacoes(Long idVeiculo, LocalDate dataInicio, LocalDate dataFim);

    List<MovimentacaoDTO> obterMovimentacoesMesAtual(Long idVeiculo);
}
