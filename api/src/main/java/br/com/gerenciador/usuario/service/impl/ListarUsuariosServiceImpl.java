package br.com.gerenciador.usuario.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gerenciador.exception.NenhumUsuarioEncontradoException;
import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.mapper.UsuarioMapper;
import br.com.gerenciador.usuario.repository.UsuarioRepository;
import br.com.gerenciador.usuario.service.ListarUsuariosService;
import br.com.gerenciador.usuario.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class ListarUsuariosServiceImpl implements ListarUsuariosService {

	private final UsuarioRepository repository;

	private final UsuarioMapper mapper;

	@Override
	public List<UsuarioDTO> executar() {
		List<Usuario> usuarios = repository.findAllBy();

		if (CollectionUtils.isEmpty(usuarios)) {
			throw new NenhumUsuarioEncontradoException();
		}

		return usuarios.stream().map(mapper::fromModel).collect(Collectors.toList());
	}
}
