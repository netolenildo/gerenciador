package br.com.gerenciador.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "gerenciador", name = "movimentacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_movimentacao")
    private Long id;

    private String descricao;

    @Column(name = "data_hora")
    private LocalDate data;

    @Column(name = "tipo_movimentacao")
    private TipoMovimentacao tipoMovimentacao;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @Column(name = "data_hora_cadastro", updatable = false)
    private LocalDateTime dataHoraCadastro;

}
