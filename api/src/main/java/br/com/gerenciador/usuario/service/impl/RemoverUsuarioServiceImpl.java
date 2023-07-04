package br.com.gerenciador.usuario.service.impl;

import br.com.gerenciador.exception.UsuarioNaoEncontradoException;
import br.com.gerenciador.usuario.repository.UsuarioRepository;
import br.com.gerenciador.usuario.service.RemoverUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoverUsuarioServiceImpl implements RemoverUsuarioService {

	private final UsuarioRepository repository;

	@Override
	public void executar(Long id) {
		if (!repository.existsById(id)) {
			throw new UsuarioNaoEncontradoException();
		}

		repository.deleteById(id);
	}
}
