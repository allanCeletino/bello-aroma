package SENAI.Ipiranga.com.bellaAroma.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SENAI.Ipiranga.com.bellaAroma.Model.Produto;

public interface  ProdutoRepository extends JpaRepository<Produto, Long>{
    public Optional<Produto> findByIdProduto(long idProduto);//
    public Optional<Produto> findByQuantidade(long quantidade);//
    public Optional<Produto> findByNomeContainingIgnoreCase(String nome);//
    List<Produto> findAllByNomeContainingIgnoreCase(String nome);
    public Optional<Produto> findByValorvenda(BigDecimal valorvenda);
    
}
