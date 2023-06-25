package br.com.gerenciador.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(schema = "gerenciador", name = "veiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_veiculo")
    private Long id;

    @Column(unique = true)
    private String placa;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veiculo")
    private List<Movimentacao> movimentacoes;
}
