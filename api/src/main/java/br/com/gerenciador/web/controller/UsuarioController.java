package br.com.gerenciador.web.controller;

import br.com.gerenciador.exception.EmailExistenteException;
import br.com.gerenciador.exception.LoginExistenteException;
import br.com.gerenciador.exception.NenhumUsuarioEncontradoException;
import br.com.gerenciador.exception.UsuarioNaoEncontradoException;
import br.com.gerenciador.models.Usuario;
import br.com.gerenciador.service.UsuarioService;
import br.com.gerenciador.web.dto.UsuarioDTO;
import br.com.gerenciador.web.form.UsuarioForm;
import br.com.gerenciador.web.mapper.UsuarioMapper;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    private final UsuarioMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody UsuarioForm usuarioForm) {
        try {
            Usuario usuario = mapper.toModel(usuarioForm);
            UsuarioDTO usuarioDTO = mapper.fromModel(service.salvarOuAtualizar(usuario));
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);
        } catch (EmailExistenteException | LoginExistenteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathParam("id") Long id, @RequestBody UsuarioForm usuarioForm) {
        try {
            Usuario usuario = mapper.toModel(usuarioForm);
            usuario.setId(id);
            UsuarioDTO usuarioDTO = mapper.fromModel(service.salvarOuAtualizar(usuario));
            return ResponseEntity.ok(usuarioDTO);
        } catch (EmailExistenteException | LoginExistenteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathParam("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(service.obterTodos().stream().map(mapper::fromModel).collect(Collectors.toList()));
        } catch (NenhumUsuarioEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obterPorId(@PathParam("id") Long id) {
        return ResponseEntity.ok(mapper.fromModel(service.obterPorId(id)));
    }

    @GetMapping
    public ResponseEntity<Object> obterPorNome(@RequestParam("nome") String nome) {
        try {
            return ResponseEntity.ok(service.obterPorNome(nome).stream().map(mapper::fromModel).collect(Collectors.toList()));
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
