package br.com.gerenciador.usuario.exception;

public class EmailExistenteException extends RuntimeException{

    public EmailExistenteException() {
        super("Já existe um usuário cadastrado com o e-mail informado.");
    }
}
