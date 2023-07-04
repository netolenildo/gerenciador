package br.com.gerenciador.usuario.service.impl;

import br.com.gerenciador.exception.EmailExistenteException;
import br.com.gerenciador.exception.LoginExistenteException;
import br.com.gerenciador.usuario.mapper.UsuarioMapper;
import br.com.gerenciador.usuario.repository.UsuarioRepository;
import br.com.gerenciador.usuario.service.CadastrarUsuarioService;
import br.com.gerenciador.usuario.dto.UsuarioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioServiceImpl implements CadastrarUsuarioService {

	private final UsuarioRepository repository;

	private final UsuarioMapper mapper;

	@Override
	public void executar(UsuarioForm usuario) {
		if (repository.existsUsuarioByEmail(usuario.getEmail())) {
			throw new EmailExistenteException();
		}

		if (repository.existsUsuarioByLogin(usuario.getLogin())) {
			throw new LoginExistenteException();
		}

		repository.save(mapper.toModel(usuario));
	}
}
