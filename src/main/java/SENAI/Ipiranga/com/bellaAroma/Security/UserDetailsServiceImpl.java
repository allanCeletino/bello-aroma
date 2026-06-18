package SENAI.Ipiranga.com.bellaAroma.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import SENAI.Ipiranga.com.bellaAroma.Model.Funcionario;
import SENAI.Ipiranga.com.bellaAroma.Repository.FuncionarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private FuncionarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Funcionario funcionario = userRepository.findByUsuario(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        
        return new UserDetailsImpl(funcionario);
    }
}

