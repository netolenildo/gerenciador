package br.com.gerenciador.exception;

public class LoginExistenteException extends RuntimeException {

    public LoginExistenteException() {
        super("Já existe um usuário cadastrado com o login informado.");
    }
}
