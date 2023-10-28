package br.com.gerenciador.movimentacao.repository;

import br.com.gerenciador.movimentacao.Movimentacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Long> {


    @Query("SELECT m FROM Movimentacao m WHERE MONTH(m.data) = :mes " +
            "AND YEAR(m.data) = :ano " +
            "AND m.veiculo.id = :idVeiculo " +
            "ORDER BY m.data, m.dataHoraCadastro ASC")
    List<Movimentacao> findMovimentacoesMesAtualByIdVeiculo(@Param("mes") Integer mes, @Param("ano") Integer ano, @Param("idVeiculo") Long idVeiculo);

    @Query("SELECT m FROM Movimentacao m WHERE m.data BETWEEN :dataInicio AND :dataFim " +
            "AND m.veiculo.id = :idVeiculo " +
            "ORDER BY m.data, m.dataHoraCadastro ASC")
    List<Movimentacao> filtrarMovimentacoesPorData(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim, @Param("idVeiculo") Long idVeiculo);
}
