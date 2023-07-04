package br.com.gerenciador.usuario.mapper;

import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.dto.UsuarioDTO;
import br.com.gerenciador.usuario.dto.UsuarioForm;

public interface UsuarioMapper {

    Usuario toModel(UsuarioForm usuarioForm);

    UsuarioDTO fromModel(Usuario usuario);
}
