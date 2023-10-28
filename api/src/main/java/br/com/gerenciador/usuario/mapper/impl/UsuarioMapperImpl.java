package br.com.gerenciador.usuario.mapper.impl;

import br.com.gerenciador.usuario.Usuario;
import br.com.gerenciador.usuario.dto.UsuarioDTO;
import br.com.gerenciador.usuario.dto.UsuarioForm;
import br.com.gerenciador.usuario.mapper.UsuarioMapper;
import br.com.gerenciador.veiculo.mapper.IVeiculoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioMapperImpl implements UsuarioMapper {

    private final IVeiculoMapper IVeiculoMapper;

    @Override
    public Usuario toModel(UsuarioForm usuarioForm) {
        return Usuario.builder()
                .login(usuarioForm.getLogin())
                .senha(usuarioForm.getSenha())
                .nome(usuarioForm.getNome())
                .email(usuarioForm.getEmail())
                .build();
    }

    @Override
    public UsuarioDTO fromModel(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .login(usuario.getLogin())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .veiculos(usuario.getVeiculos().stream().map(IVeiculoMapper::fromModel).collect(Collectors.toSet()))
                .build();
    }
}
