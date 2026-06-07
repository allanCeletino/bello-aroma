package SENAI.Ipiranga.com.bellaAroma.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SENAI.Ipiranga.com.bellaAroma.Model.Funcionario;
import SENAI.Ipiranga.com.bellaAroma.Model.UsuarioLogin;
import SENAI.Ipiranga.com.bellaAroma.Repository.FuncionarioRepository;
import SENAI.Ipiranga.com.bellaAroma.Service.FuncionarioService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private FuncionarioService funcionarioService;

    // Buscar por ID (Ajustado para usar o método customizado do seu Repository)
    @GetMapping("/id/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable long id) {
        return repository.findByIdFuncionario(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar por Nome (Se o banco encontrar, retorna 200 OK)
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Funcionario> getByNome(@PathVariable String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar por Status (Como status pode retornar mais de um, ou um único opcional)
    @GetMapping("/status/{status}")
    public ResponseEntity<Funcionario> getByStatus(@PathVariable String status) {
        return repository.findByStatus(status)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // Buscar por Número do Pedido (Adicionado baseado no seu Repository)
    @GetMapping("/pedido/{nPedido}")
    public ResponseEntity<Funcionario> getByNPedido(@PathVariable String nPedido) {
        return repository.findByNPedido(nPedido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint de Login/Autenticação
    @PostMapping("/logar")
    public ResponseEntity<UsuarioLogin> authentication(
            @RequestBody Optional<UsuarioLogin> user) {

        return funcionarioService.logar(user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    // Endpoint de Cadastro (Envia para o Service criptografar a senha)
   @PostMapping("/cadastrar")
    public ResponseEntity<Funcionario> post(
            @RequestBody Funcionario funcionario) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.cadastrarFuncionario(funcionario));
    }
   @DeleteMapping("/deletar/{idFuncionario}") 
       public void delete(@PathVariable long idFuncionario) { 
        repository.deleteById(idFuncionario);
    }
}