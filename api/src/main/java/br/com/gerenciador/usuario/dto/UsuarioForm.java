package br.com.gerenciador.usuario.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UsuarioForm {

    @NotBlank
    private String login;

    @NotBlank
    private String senha;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;
}
