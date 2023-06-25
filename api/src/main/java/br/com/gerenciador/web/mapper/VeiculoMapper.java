package br.com.gerenciador.web.mapper;

import br.com.gerenciador.models.Veiculo;
import br.com.gerenciador.web.dto.VeiculoDTO;
import br.com.gerenciador.web.form.VeiculoForm;

public interface VeiculoMapper {

    Veiculo toModel(VeiculoForm veiculoForm);

    VeiculoDTO fromModel(Veiculo veiculo);
}
