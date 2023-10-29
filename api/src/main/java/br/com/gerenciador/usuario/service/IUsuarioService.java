package br.com.gerenciador.usuario.service;

import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.dto.UsuarioDTO;
import br.com.gerenciador.usuario.dto.UsuarioForm;

import java.util.List;

public interface IUsuarioService {

    void cadastrar(UsuarioForm usuarioForm);

    void atualizar(UsuarioForm usuarioForm, Long id);

    void remover(Long id);

    List<UsuarioDTO> listar();

    Usuario obterUsuarioPorLogin(String login);
}
