package SENAI.Ipiranga.com.bellaAroma.Security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import SENAI.Ipiranga.com.bellaAroma.Model.Funcionario;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    
    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;
    
    public UserDetailsImpl(Funcionario funcionario) {
        this.userName = funcionario.getUsuario();
        this.password = funcionario.getSenha();
    }
    
    public UserDetailsImpl() {}
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {    
        return List.of();
    }
    
    @Override
    public String getPassword() {   
        return password;
    }
    
    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}