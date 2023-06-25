package br.com.gerenciador.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "gerenciador", name = "papel")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Papel {

    @Id
    private Long id;

    @Column(unique = true)
    private String descricao;
}
