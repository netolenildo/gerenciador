package br.com.gerenciador.comum;

import br.com.gerenciador.logon.CustomUserDetails;
import br.com.gerenciador.usuario.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class AbstractService {

    public Usuario getUsuarioLogado() {
        CustomUserDetails usuarioLogado = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return Usuario.builder()
                .id(usuarioLogado.getId())
                .login(usuarioLogado.getUsername())
                .senha(usuarioLogado.getPassword())
                .build();
    }

}
