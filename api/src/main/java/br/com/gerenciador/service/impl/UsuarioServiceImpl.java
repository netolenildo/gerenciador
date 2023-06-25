package br.com.gerenciador.service.impl;

import br.com.gerenciador.exception.EmailExistenteException;
import br.com.gerenciador.exception.LoginExistenteException;
import br.com.gerenciador.exception.NenhumUsuarioEncontradoException;
import br.com.gerenciador.exception.UsuarioNaoEncontradoException;
import br.com.gerenciador.models.Usuario;
import br.com.gerenciador.repository.UsuarioRepository;
import br.com.gerenciador.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvarOuAtualizar(Usuario usuario) {
        if (usuarioRepository.existsUsuarioByEmail(usuario.getEmail())) {
            throw new EmailExistenteException();
        }

        if (usuarioRepository.existsUsuarioByLogin(usuario.getLogin())) {
            throw new LoginExistenteException();
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public void remover(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> obterTodos() {
        List<Usuario> usuarios = usuarioRepository.findAllBy();

        if (CollectionUtils.isEmpty(usuarios)) {
            throw new NenhumUsuarioEncontradoException();
        }

        return usuarios;
    }

    @Override
    public Usuario obterPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> obterPorNome(String nome) {
        List<Usuario> usuarios = usuarioRepository.findUsuarioByNome(nome);

        if (CollectionUtils.isEmpty(usuarios)) {
            throw new UsuarioNaoEncontradoException();
        }

        return usuarios;
    }
}
