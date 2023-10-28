package br.com.gerenciador.veiculo.dto;

import br.com.gerenciador.movimentacao.dto.MovimentacaoDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class VeiculoDTO {

    private final Long id;

    private final String placa;

    private List<MovimentacaoDTO> movimentacoes;

    @Builder
    private VeiculoDTO(Long id, String placa) {
        this.id = id;
        this.placa = placa;
    }

    public void setMovimentacoes(List<MovimentacaoDTO> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
}
