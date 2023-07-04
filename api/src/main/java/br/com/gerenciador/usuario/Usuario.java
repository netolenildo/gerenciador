package br.com.gerenciador.usuario;

import br.com.gerenciador.autorizacao.Autorizacao;
import br.com.gerenciador.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(schema = "gerenciador", name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id;

    @Column(unique = true)
    private String login;

    private String senha;

    private String nome;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "usuario_papeis",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_papel")
    )
    private Set<Autorizacao> papeis;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Veiculo> veiculos;

}
