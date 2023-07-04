package br.com.gerenciador.usuario.service;

import br.com.gerenciador.usuario.dto.UsuarioForm;

public interface AtualizarUsuarioService {

	void executar(UsuarioForm usuario, Long id);
}
