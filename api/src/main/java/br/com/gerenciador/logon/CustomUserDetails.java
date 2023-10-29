package br.com.gerenciador.logon;

import br.com.gerenciador.autorizacao.EPapel;
import br.com.gerenciador.usuario.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CustomUserDetails implements UserDetails {

    @Getter
    @Setter
    private Long id;

    private String login;

    private String senha;

    private Collection<? extends GrantedAuthority> autorizacoes;

    public CustomUserDetails(Usuario usuario) {
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.autorizacoes = getAutorizacoes(usuario);
    }

    private Collection<? extends GrantedAuthority> getAutorizacoes(Usuario usuario) {
        return usuario.getAutorizacoes().stream().map(a -> new SimpleGrantedAuthority(EPapel.getPapel(a.getPapel()))).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorizacoes;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
