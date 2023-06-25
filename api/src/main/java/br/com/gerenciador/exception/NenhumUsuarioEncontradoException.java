package br.com.gerenciador.exception;

public class NenhumUsuarioEncontradoException extends RuntimeException{

    public NenhumUsuarioEncontradoException() {
        super("Nenhum usuário encontrado.");
    }

}
