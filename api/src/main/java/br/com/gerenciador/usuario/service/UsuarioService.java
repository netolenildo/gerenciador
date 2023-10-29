package br.com.gerenciador.usuario.service;

import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.dto.UsuarioDTO;
import br.com.gerenciador.usuario.dto.UsuarioForm;
import br.com.gerenciador.usuario.exception.EmailExistenteException;
import br.com.gerenciador.usuario.exception.LoginExistenteException;
import br.com.gerenciador.usuario.exception.NenhumUsuarioEncontradoException;
import br.com.gerenciador.usuario.exception.UsuarioNaoEncontradoException;
import br.com.gerenciador.usuario.mapper.UsuarioMapper;
import br.com.gerenciador.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository repository;

    private final UsuarioMapper mapper;

    @Override
    public void cadastrar(UsuarioForm usuarioForm) {
        if (repository.existsUsuarioByEmail(usuarioForm.getEmail())) {
            throw new EmailExistenteException();
        }

        if (repository.existsUsuarioByLogin(usuarioForm.getLogin())) {
            throw new LoginExistenteException();
        }

        repository.save(mapper.toModel(usuarioForm));
    }

    @Override
    public void atualizar(UsuarioForm usuarioForm, Long id) {
        Usuario usuarioBd = this.repository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);

        if (!usuarioForm.getEmail().equals(usuarioBd.getEmail()) && repository.existsUsuarioByEmail(usuarioForm.getEmail())) {
            throw new EmailExistenteException();
        }

        if (!usuarioForm.getLogin().equals(usuarioBd.getLogin()) && repository.existsUsuarioByLogin(usuarioForm.getLogin())) {
            throw new LoginExistenteException();
        }

        Usuario entity = mapper.toModel(usuarioForm);
        entity.setId(id);

        repository.save(entity);
    }

    @Override
    public void remover(Long id) {
        if (!repository.existsById(id)) {
            throw new UsuarioNaoEncontradoException();
        }

        repository.deleteById(id);
    }

    @Override
    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = repository.findAllBy();

        if (CollectionUtils.isEmpty(usuarios)) {
            throw new NenhumUsuarioEncontradoException();
        }

        return usuarios.stream().map(mapper::fromModel).collect(Collectors.toList());
    }

    @Override
    public Usuario obterUsuarioPorLogin(String login) {
        return this.repository.findUsuarioByLogin(login);
    }
}
