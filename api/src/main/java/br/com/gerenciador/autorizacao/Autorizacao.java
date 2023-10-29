package br.com.gerenciador.autorizacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema="gerenciador", name = "autorizacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autorizacao {

    @Id
    @Column(name="id_autorizacao")
    private Long id;

    @Column(unique = true)
    private String nome;

    private Integer papel;
}
