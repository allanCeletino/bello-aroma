package SENAI.Ipiranga.com.bellaAroma.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import SENAI.Ipiranga.com.bellaAroma.Model.Funcionario;
import SENAI.Ipiranga.com.bellaAroma.Model.UsuarioLogin;
import SENAI.Ipiranga.com.bellaAroma.Repository.FuncionarioRepository;


@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario cadastrarFuncionario(Funcionario funcionario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaCriptografada = encoder.encode(funcionario.getSenha());
        funcionario.setSenha(senhaCriptografada);
        return repository.save(funcionario);
    }

    public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> user) {
    // 1. Validação de segurança obrigatória para o Optional não quebrar o sistema
    if (user == null || user.isEmpty()) {
        return Optional.empty();
    }

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    Optional<Funcionario> funcionario = repository.findByUsuario(user.get().getUsuario());   
    if (funcionario.isPresent()) {
        if (encoder.matches(user.get().getSenha(), funcionario.get().getSenha())) {
            String auth = user.get().getUsuario() + ":" + user.get().getSenha();
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.US_ASCII));
            String authHeader = "Basic " + encodedAuth;
            user.get().setToken(authHeader);
            user.get().setId(funcionario.get().getIdFuncionario());
            user.get().setNome(funcionario.get().getNome());
            return user;
        }
    }
    return Optional.empty();
}

}
