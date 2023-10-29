package br.com.gerenciador.logon.service;

import br.com.gerenciador.logon.CustomUserDetails;
import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.exception.UsuarioNaoEncontradoException;
import br.com.gerenciador.usuario.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogonService implements UserDetailsService {

    private final IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = Optional.of(this.usuarioService.obterUsuarioPorLogin(username));

        return new CustomUserDetails(usuario.orElseThrow(UsuarioNaoEncontradoException::new));
    }
}
