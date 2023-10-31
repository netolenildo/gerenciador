package br.com.gerenciador.usuario.controller;

import br.com.gerenciador.usuario.exception.EmailExistenteException;
import br.com.gerenciador.usuario.exception.LoginExistenteException;
import br.com.gerenciador.usuario.exception.NenhumUsuarioEncontradoException;
import br.com.gerenciador.usuario.exception.UsuarioNaoEncontradoException;
import br.com.gerenciador.usuario.service.*;
import br.com.gerenciador.usuario.dto.UsuarioForm;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usuarios")
@RolesAllowed("ADMIN")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody @Valid UsuarioForm usuarioForm) {
        try {
            usuarioService.cadastrar(usuarioForm);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (EmailExistenteException | LoginExistenteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @Valid @RequestBody UsuarioForm usuarioForm) {
        try {
            usuarioService.atualizar(usuarioForm, id);
            return ResponseEntity.ok().build();
        } catch (EmailExistenteException | LoginExistenteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        try {
            usuarioService.remover(id);
            return ResponseEntity.noContent().build();
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(usuarioService.listar());
        } catch (NenhumUsuarioEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
