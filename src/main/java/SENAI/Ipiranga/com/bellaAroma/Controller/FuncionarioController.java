package SENAI.Ipiranga.com.bellaAroma.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SENAI.Ipiranga.com.bellaAroma.Model.Funcionario;
import SENAI.Ipiranga.com.bellaAroma.Model.Produto;
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

 // Buscar por Nome (Retorna a lista de quem tem essa parte do nome)
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Funcionario>> getByNome(@PathVariable String nome) {
        List<Funcionario> lista = repository.findByNomeContainingIgnoreCase(nome);
        return lista.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(lista);
    }

    // Buscar por Status (Retorna a lista de ativos ou inativos)
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Funcionario>> getByStatus(@PathVariable String status) {
        List<Funcionario> lista = repository.findByStatusContainingIgnoreCase(status);
        return lista.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(lista);
    }
    
    // Buscar por Número do Pedido
    @GetMapping("/npedido/{nPedido}")
    public ResponseEntity<Funcionario> getByNPedido(@PathVariable Long nPedido) {
        return repository.findByNPedido(nPedido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    

    // Endpoint de Login/Autenticação
   @PostMapping("/logar")
public ResponseEntity<UsuarioLogin> autenticarFuncionario(@RequestBody UsuarioLogin user) {
    // Passamos o 'user' envelopado em um Optional para o seu Service não quebrar
    return funcionarioService.logar(Optional.of(user))
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
}

    // Endpoint de Cadastro (Envia para o Service criptografar a senha)
   @PostMapping("/cadastrar")
    public ResponseEntity<Funcionario> post(
            @RequestBody Funcionario funcionario) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.cadastrarFuncionario(funcionario));
    }

@DeleteMapping("/delete/{idFuncionario}")
   public ResponseEntity<Funcionario> delete(@PathVariable long idFuncionario) {
    repository.deleteById(idFuncionario);
    return ResponseEntity.noContent().build();
    }

      @PutMapping("/atualizar/{idFuncionario}")
    public ResponseEntity<Funcionario> put(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(funcionario));
    }
}