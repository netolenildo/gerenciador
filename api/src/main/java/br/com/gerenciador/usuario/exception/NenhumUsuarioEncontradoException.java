package br.com.gerenciador.usuario.exception;

public class NenhumUsuarioEncontradoException extends RuntimeException{

    public NenhumUsuarioEncontradoException() {
        super("Nenhum usuário encontrado.");
    }

}
