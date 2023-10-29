package br.com.gerenciador.movimentacao;

import br.com.gerenciador.movimentacao.converter.TipoMovimentacaoConverter;
import br.com.gerenciador.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema="gerenciador", name = "movimentacao")
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
    @Convert(converter = TipoMovimentacaoConverter.class)
    private ETipoMovimentacao tipoMovimentacao;

    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @Column(name = "data_hora_cadastro", updatable = false)
    private LocalDateTime dataHoraCadastro;


    public Double getValor() {
        return valor * tipoMovimentacao.getValor();
    }
}
