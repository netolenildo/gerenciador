package br.com.gerenciador.usuario.service.impl;

import br.com.gerenciador.exception.EmailExistenteException;
import br.com.gerenciador.exception.LoginExistenteException;
import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.mapper.UsuarioMapper;
import br.com.gerenciador.usuario.repository.UsuarioRepository;
import br.com.gerenciador.usuario.service.AtualizarUsuarioService;
import br.com.gerenciador.usuario.dto.UsuarioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarUsuarioServiceImpl implements AtualizarUsuarioService {

	private final UsuarioRepository repository;

	private final UsuarioMapper mapper;

	@Override
	public void executar(UsuarioForm usuario, Long id) {
		Usuario usuarioBanco = repository.findById(id).orElse(new Usuario());

		if (!usuario.getEmail().equals(usuarioBanco.getEmail()) && repository.existsUsuarioByEmail(usuario.getEmail())) {
			throw new EmailExistenteException();
		}

		if (!usuario.getLogin().equals(usuarioBanco.getLogin()) && repository.existsUsuarioByLogin(usuario.getLogin())) {
			throw new LoginExistenteException();
		}

		Usuario entity = mapper.toModel(usuario);
		entity.setId(id);

		repository.save(entity);
	}
}
