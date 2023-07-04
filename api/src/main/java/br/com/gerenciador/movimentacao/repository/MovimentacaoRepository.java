package br.com.gerenciador.movimentacao.repository;

import br.com.gerenciador.movimentacao.Movimentacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Long> {


    @Query("SELECT m FROM Movimentacao m WHERE MONTH(m.data) = :mes AND m.veiculo.id = :idVeiculo " +
            "ORDER BY m.data, m.dataHoraCadastro ASC")
    List<Movimentacao> findMovimentacoesMesAtualByIdVeiculo(@Param("mes") Integer mes, @Param("idVeiculo") Long idVeiculo);
}
