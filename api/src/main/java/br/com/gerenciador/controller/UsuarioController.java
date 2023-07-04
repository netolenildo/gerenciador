package br.com.gerenciador.controller;

import br.com.gerenciador.exception.EmailExistenteException;
import br.com.gerenciador.exception.LoginExistenteException;
import br.com.gerenciador.exception.NenhumUsuarioEncontradoException;
import br.com.gerenciador.exception.UsuarioNaoEncontradoException;
import br.com.gerenciador.usuario.service.AtualizarUsuarioService;
import br.com.gerenciador.usuario.service.CadastrarUsuarioService;
import br.com.gerenciador.usuario.service.ListarUsuariosService;
import br.com.gerenciador.usuario.service.ObterUsuarioPorNomeService;
import br.com.gerenciador.usuario.service.RemoverUsuarioService;
import br.com.gerenciador.usuario.dto.UsuarioForm;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final AtualizarUsuarioService atualizarUsuarioService;

    private final CadastrarUsuarioService cadastrarUsuarioService;

    private final ListarUsuariosService listarUsuariosService;

    private final ObterUsuarioPorNomeService obterUsuarioPorNomeService;

    private final RemoverUsuarioService removerUsuarioService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody UsuarioForm usuarioForm) {
        try {
            cadastrarUsuarioService.executar(usuarioForm);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (EmailExistenteException | LoginExistenteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathParam("id") Long id, @RequestBody UsuarioForm usuarioForm) {
        try {
            atualizarUsuarioService.executar(usuarioForm, id);
            return ResponseEntity.ok().build();
        } catch (EmailExistenteException | LoginExistenteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathParam("id") Long id) {
        try {
            removerUsuarioService.executar(id);
            return ResponseEntity.noContent().build();
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> listar() {
        try {
            return ResponseEntity.ok(listarUsuariosService.executar());
        } catch (NenhumUsuarioEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> obterPorNome(@RequestParam("nome") String nome) {
        try {
            return ResponseEntity.ok(obterUsuarioPorNomeService.executar(nome));
        } catch (UsuarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
