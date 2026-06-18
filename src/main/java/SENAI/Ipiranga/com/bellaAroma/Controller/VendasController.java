package SENAI.Ipiranga.com.bellaAroma.Controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SENAI.Ipiranga.com.bellaAroma.Model.Vendas;
import SENAI.Ipiranga.com.bellaAroma.Repository.VendasRepository;

@RestController
@RequestMapping("/Vendas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VendasController {
    @Autowired
    private VendasRepository repository;

    @GetMapping("/idVendas/{idVendas}")
    public ResponseEntity<Vendas> GetById(@PathVariable long idVendas){
        return repository.findByIdVendas(idVendas)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/valor/{valor}")
    public ResponseEntity<Vendas> getByValor(@PathVariable BigDecimal valor){
        return repository.findByValor(valor)
         .map(ResponseEntity::ok)
         .orElse(ResponseEntity.notFound().build());
    }
   // 4. ATUALIZAR VENDA (Totalmente corrigido!)
    @PutMapping("/atualizar")
    public ResponseEntity<Vendas> put(@RequestBody Vendas vendas) { // Recebe Vendas, retorna Vendas
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(vendas));
    }

    // 6. DELETAR TIPO DE PRODUTO
   @DeleteMapping("/deletar/{idVendas}")
    public void delete(@PathVariable long idVendas) {
    repository.deleteById(idVendas);
}
}
