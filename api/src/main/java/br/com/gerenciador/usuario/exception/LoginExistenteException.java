package br.com.gerenciador.usuario.exception;

public class LoginExistenteException extends RuntimeException {

    public LoginExistenteException() {
        super("Já existe um usuário cadastrado com o login informado.");
    }
}
