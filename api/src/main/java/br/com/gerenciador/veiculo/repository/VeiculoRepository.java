package br.com.gerenciador.veiculo.repository;

import br.com.gerenciador.veiculo.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

    @Query("SELECT v.id, v.placa FROM Veiculo v WHERE v.usuario.id = :id ORDER BY v.placa ASC")
    List<Veiculo> findVeiculosByIdUsuario(Long idUsuario);

    boolean existsVeiculoByPlaca(String placa);


}
