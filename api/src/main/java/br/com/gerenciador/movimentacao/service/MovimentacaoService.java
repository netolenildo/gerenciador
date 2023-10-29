package br.com.gerenciador.movimentacao.service;

import br.com.gerenciador.comum.AbstractService;
import br.com.gerenciador.movimentacao.dto.MovimentacaoDTO;
import br.com.gerenciador.movimentacao.dto.MovimentacaoForm;
import br.com.gerenciador.movimentacao.mapper.IMovimentacaoMapper;
import br.com.gerenciador.movimentacao.repository.MovimentacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovimentacaoService extends AbstractService implements IMovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    private final IMovimentacaoMapper movimentacaoMapper;

    @Override
    public void cadastrar(MovimentacaoForm movimentacaoForm) {
        this.movimentacaoRepository.save(this.movimentacaoMapper.toModel(movimentacaoForm));
    }

    @Override
    public void remover(Long id) {
        this.movimentacaoRepository.deleteById(id);
    }

    @Override
    public List<MovimentacaoDTO> filtrarMovimentacoes(Long idVeiculo, LocalDate dataInicio, LocalDate dataFim) {
        return this.movimentacaoRepository.filtrarMovimentacoesPorData(dataInicio, dataFim, idVeiculo)
                .stream().map(this.movimentacaoMapper::fromModel).collect(Collectors.toList());
    }

    @Override
    public List<MovimentacaoDTO> obterMovimentacoesMesAtual(Long idVeiculo) {
        Integer mes = LocalDate.now().getMonthValue();
        Integer ano = LocalDate.now().getYear();
        return this.movimentacaoRepository.findMovimentacoesMesAtualByIdVeiculo(mes, ano, idVeiculo)
                .stream().map(this.movimentacaoMapper::fromModel).collect(Collectors.toList());
    }
}
