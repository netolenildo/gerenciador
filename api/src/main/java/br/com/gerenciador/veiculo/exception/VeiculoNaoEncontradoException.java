package br.com.gerenciador.veiculo.exception;

public class VeiculoNaoEncontradoException extends RuntimeException {

    public VeiculoNaoEncontradoException() {
        super("Veiculo não encontrado.");
    }
}
