package br.com.gerenciador.repository;

import br.com.gerenciador.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findAllBy();

    @Query("SELECT u FROM Usuario u WHERE u.nome ILIKE :nome% ORDER BY u.nome ASC")
    List<Usuario> findUsuarioByNome(@Param("nome") String nome);

    boolean existsUsuarioByEmail(String email);

    boolean existsUsuarioByLogin(String login);
}
