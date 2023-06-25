package br.com.gerenciador.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado.");
    }
}
