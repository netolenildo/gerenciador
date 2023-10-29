package br.com.gerenciador.veiculo.service;

import br.com.gerenciador.veiculo.dto.VeiculoDTO;
import br.com.gerenciador.veiculo.dto.VeiculoForm;

import java.util.List;

public interface IVeiculoService {

    void cadastrar(VeiculoForm veiculoForm);

    void atualizar(VeiculoForm veiculoForm, Long id);

    void remover(Long id);

    List<VeiculoDTO> listarVeiculos();

    VeiculoDTO obterVeiculo(Long id);
}
