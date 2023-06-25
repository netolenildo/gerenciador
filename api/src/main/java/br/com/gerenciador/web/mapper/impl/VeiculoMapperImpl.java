package br.com.gerenciador.web.mapper.impl;

import br.com.gerenciador.models.Veiculo;
import br.com.gerenciador.web.dto.VeiculoDTO;
import br.com.gerenciador.web.form.VeiculoForm;
import br.com.gerenciador.web.mapper.VeiculoMapper;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapperImpl implements VeiculoMapper {

    @Override
    public Veiculo toModel(VeiculoForm veiculoForm) {
        return Veiculo.builder()
                .placa(veiculoForm.getPlaca())
                .build();
    }

    @Override
    public VeiculoDTO fromModel(Veiculo veiculo) {
        return VeiculoDTO.builder()
                .id(veiculo.getId())
                .placa(veiculo.getPlaca())
                .build();
    }
}
