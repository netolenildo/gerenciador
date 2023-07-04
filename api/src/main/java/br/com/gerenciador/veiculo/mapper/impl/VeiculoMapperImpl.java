package br.com.gerenciador.veiculo.mapper.impl;

import br.com.gerenciador.veiculo.Veiculo;
import br.com.gerenciador.veiculo.dto.VeiculoDTO;
import br.com.gerenciador.veiculo.dto.VeiculoForm;
import br.com.gerenciador.veiculo.mapper.VeiculoMapper;
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
