package br.com.gerenciador.movimentacao.controller;

import br.com.gerenciador.movimentacao.dto.MovimentacaoForm;
import br.com.gerenciador.movimentacao.service.IMovimentacaoService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movimentacoes")
public class MovimentacaoController {

    private final IMovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody MovimentacaoForm movimentacaoForm) {
        try {
            this.movimentacaoService.cadastrar(movimentacaoForm);
            return  ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        try {
            this.movimentacaoService.remover(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> listar(@PathParam("idVeiculo") Long idVeiculo,
                                         @PathParam("dataInicio") LocalDate dataInicio,
                                         @PathParam("dataFim") LocalDate dataFim) {
        try {
            return ResponseEntity.ok(this.movimentacaoService.filtrarMovimentacoes(idVeiculo, dataInicio, dataFim));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
