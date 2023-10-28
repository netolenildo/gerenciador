package br.com.gerenciador.veiculo.mapper;

import br.com.gerenciador.veiculo.Veiculo;
import br.com.gerenciador.veiculo.dto.VeiculoDTO;
import br.com.gerenciador.veiculo.dto.VeiculoForm;

public interface IVeiculoMapper {

    Veiculo toModel(VeiculoForm veiculoForm);

    VeiculoDTO fromModel(Veiculo veiculo);
}
