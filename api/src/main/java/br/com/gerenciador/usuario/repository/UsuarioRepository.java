package br.com.gerenciador.usuario.repository;

import br.com.gerenciador.usuario.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findAllBy();

    boolean existsUsuarioByEmail(String email);

    boolean existsUsuarioByLogin(String login);

    Usuario findUsuarioByLogin(String login);
}
