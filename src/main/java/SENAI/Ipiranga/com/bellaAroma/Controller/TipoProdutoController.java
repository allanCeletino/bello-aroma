package SENAI.Ipiranga.com.bellaAroma.Controller;

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

import SENAI.Ipiranga.com.bellaAroma.Model.TipoProduto;
import SENAI.Ipiranga.com.bellaAroma.Repository.TipoProdutoRepository;

@RestController
@RequestMapping("/tipoproduto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoRepository repository;

    // 1. BUSCA POR ID (Retorna Optional -> Usa .map e .orElse)
    @GetMapping("/id/{idTipoProduto}")
    public ResponseEntity<TipoProduto> getById(@PathVariable long idTipoProduto) {
        return repository.findById(idTipoProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2. BUSCA POR TIPO/CATEGORIA (Retorna List -> Usa a validação de lista)
    // Exemplo: Buscar por "Cosméticos" ou "Perfumes" traz todos dessa categoria
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<TipoProduto>> getByTipo(@PathVariable String tipo) {
        List<TipoProduto> lista = repository.findByTipoContainingIgnoreCase(tipo);
        
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista);
    }

    // 3. BUSCA POR CÓDIGO DO PRODUTO (Retorna Optional -> Usa .map e .orElse)
    @GetMapping("/codigo/{codproduto}")
    public ResponseEntity<TipoProduto> getByCodProduto(@PathVariable String codproduto) {
        return repository.findByCodproduto(codproduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. CADASTRAR NOVO TIPO DE PRODUTO
    @PostMapping("/cadastrar")
    public ResponseEntity<TipoProduto> post(@RequestBody TipoProduto tipoProduto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(tipoProduto));
    }

    // 5. ATUALIZAR TIPO DE PRODUTO
    @PutMapping("/atualizar")
    public ResponseEntity<TipoProduto> put(@RequestBody TipoProduto tipoProduto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(tipoProduto));
    }

    // 6. DELETAR TIPO DE PRODUTO
   @DeleteMapping("/deletar/{id}")
public void delete(@PathVariable long id) {
    repository.deleteById(id);
}
}