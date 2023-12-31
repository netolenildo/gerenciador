package br.com.gerenciador.veiculo.service;

import br.com.gerenciador.movimentacao.service.IMovimentacaoService;
import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.service.UsuarioService;
import br.com.gerenciador.veiculo.Veiculo;
import br.com.gerenciador.veiculo.dto.VeiculoDTO;
import br.com.gerenciador.veiculo.dto.VeiculoForm;
import br.com.gerenciador.veiculo.exception.VeiculoNaoEncontradoException;
import br.com.gerenciador.veiculo.mapper.IVeiculoMapper;
import br.com.gerenciador.veiculo.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VeiculoService implements IVeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final IMovimentacaoService movimentacaoService;

    private final UsuarioService usuarioService;

    private final IVeiculoMapper veiculoMapper;

    @Override
    public void cadastrar(VeiculoForm veiculoForm) {
        Veiculo veiculo = this.veiculoMapper.toModel(veiculoForm);
        veiculo.setUsuario(getUsuarioLogado());
        this.veiculoRepository.save(veiculo);
    }

    @Override
    public void atualizar(VeiculoForm veiculoForm, Long id) {
        Veiculo veiculo = this.veiculoMapper.toModel(veiculoForm);
        veiculo.setId(id);
        this.veiculoRepository.save(veiculo);
    }

    @Override
    public void remover(Long id) {
        this.veiculoRepository.deleteById(id);
    }

    @Override
    public List<VeiculoDTO> listarVeiculos() {
        Usuario usuario = getUsuarioLogado();
        return this.veiculoRepository.findVeiculosByIdUsuario(usuario.getId()).stream().map(this.veiculoMapper::fromModel).collect(Collectors.toList());
    }

    @Override
    public VeiculoDTO obterVeiculo(Long id) {
       VeiculoDTO veiculo = this.veiculoMapper.fromModel(this.veiculoRepository.findById(id).orElseThrow(VeiculoNaoEncontradoException::new));
       veiculo.setMovimentacoes(this.movimentacaoService.obterMovimentacoesMesAtual(id));

       return veiculo;
    }

    private Usuario getUsuarioLogado() {
        UserDetails usuarioLogado = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.usuarioService.obterUsuarioPorLogin(usuarioLogado.getUsername());
    }
}
