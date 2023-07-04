package br.com.gerenciador.usuario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gerenciador.exception.UsuarioNaoEncontradoException;
import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.mapper.UsuarioMapper;
import br.com.gerenciador.usuario.repository.UsuarioRepository;
import br.com.gerenciador.usuario.service.ObterUsuarioPorNomeService;
import br.com.gerenciador.usuario.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class ObterUsuarioPorNomeServiceImpl implements ObterUsuarioPorNomeService {

	private final UsuarioRepository repository;

	private final UsuarioMapper mapper;

	@Override public List<UsuarioDTO> executar(String nome) {
		List<Usuario> usuarios = repository.findUsuarioByNome(nome);

		if (CollectionUtils.isEmpty(usuarios)) {
			throw new UsuarioNaoEncontradoException();
		}

		return usuarios.stream().map(mapper::fromModel).collect(Collectors.toList());
	}
}
