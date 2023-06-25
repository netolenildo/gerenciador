package br.com.gerenciador.web.mapper.impl;

import br.com.gerenciador.models.Usuario;
import br.com.gerenciador.web.dto.UsuarioDTO;
import br.com.gerenciador.web.form.UsuarioForm;
import br.com.gerenciador.web.mapper.UsuarioMapper;
import br.com.gerenciador.web.mapper.VeiculoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioMapperImpl implements UsuarioMapper {

    private final VeiculoMapper veiculoMapper;

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
                .veiculos(usuario.getVeiculos().stream().map(veiculoMapper::fromModel).collect(Collectors.toSet()))
                .build();
    }
}
