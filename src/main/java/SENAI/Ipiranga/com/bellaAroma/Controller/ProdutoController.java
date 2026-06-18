package SENAI.Ipiranga.com.bellaAroma.Controller;

import java.math.BigDecimal;
import java.util.List;

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

import SENAI.Ipiranga.com.bellaAroma.Model.Produto;
import SENAI.Ipiranga.com.bellaAroma.Repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    // 1. BUSCA POR ID (Perfeito para ver detalhes do produto)
    @GetMapping("/idProduto/{idProduto}")
    public ResponseEntity<Produto> getByIdProduto(@PathVariable long idProduto) {
        return repository.findByIdProduto(idProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2. BUSCA POR QUANTIDADE
    @GetMapping("/quantidade/{quantidade}")
    public ResponseEntity<Produto> getByQuantidade(@PathVariable long quantidade){
        return repository.findByQuantidade(quantidade)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. BUSCA POR PREÇO / VALOR DE VENDA (Corrigido a rota e o parâmetro)
    @GetMapping("/preco/{valorVenda}")
    public ResponseEntity<Produto> getByValorVenda(@PathVariable BigDecimal valorVenda){
        return repository.findByValorvenda(valorVenda)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. GET SIMPLES POR NOME (O formato de lista que você queria, corrigido e fechado!)
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
        List<Produto> listaProdutos = repository.findAllByNomeContainingIgnoreCase(nome);
        if (listaProdutos.isEmpty()) { // Se a lista veio vazia, avisa que não tem nad
            return ResponseEntity.noContent().build(); // Se achou, entrega a lista completa (com 1, 5 ou 20 itens)
        }
        return ResponseEntity.ok(listaProdutos);
    } 

    // 5. ATUALIZAR PRODUTO
    @PutMapping("/atualizar/{idProduto}")
    public ResponseEntity<Produto> put(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(produto));
    }

    // 6. DELETAR PRODUTO
  @DeleteMapping("/deletar/{idProduto}") // Nome igual aqui
    public void delete(@PathVariable long idProduto) { // Nome igual aqui
    repository.deleteById(idProduto);
    }
@PostMapping("/cadastrar")
public ResponseEntity<Produto> post(@RequestBody Produto produto) {
    // O Controller fala direto com o Repository e salva no banco!
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(repository.save(produto));
}
}