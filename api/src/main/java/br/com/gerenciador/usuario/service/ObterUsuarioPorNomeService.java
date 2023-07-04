package br.com.gerenciador.usuario.service;

import java.util.List;

import br.com.gerenciador.usuario.dto.UsuarioDTO;

public interface ObterUsuarioPorNomeService {

	List<UsuarioDTO> executar(String nome);

}
