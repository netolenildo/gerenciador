package br.com.gerenciador.service;

import br.com.gerenciador.models.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario salvarOuAtualizar(Usuario usuario);

    void remover(Long id);

    List<Usuario> obterTodos();

    Usuario obterPorId(Long id);

    List<Usuario> obterPorNome(String nome);
}
