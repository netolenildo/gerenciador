package br.com.gerenciador.veiculo.controller;

import br.com.gerenciador.veiculo.dto.VeiculoForm;
import br.com.gerenciador.veiculo.exception.VeiculoNaoEncontradoException;
import br.com.gerenciador.veiculo.service.IVeiculoService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/veiculos")
public class VeiculoController {

    private final IVeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody VeiculoForm veiculoForm) {
        try {
            this.veiculoService.cadastrar(veiculoForm);
            return  ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @Valid @RequestBody VeiculoForm veiculoForm) {
        try {
            this.veiculoService.atualizar(veiculoForm, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        try {
            this.veiculoService.remover(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> listar(@PathParam("idUsuario") Long idUsuario) {
        try {
            return ResponseEntity.ok(this.veiculoService.listarVeiculos(idUsuario));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.veiculoService.obterVeiculo(id));
        } catch (VeiculoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
