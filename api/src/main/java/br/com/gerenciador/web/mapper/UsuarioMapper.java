package br.com.gerenciador.web.mapper;

import br.com.gerenciador.models.Usuario;
import br.com.gerenciador.web.dto.UsuarioDTO;
import br.com.gerenciador.web.form.UsuarioForm;

public interface UsuarioMapper {

    Usuario toModel(UsuarioForm usuarioForm);

    UsuarioDTO fromModel(Usuario usuario);
}
