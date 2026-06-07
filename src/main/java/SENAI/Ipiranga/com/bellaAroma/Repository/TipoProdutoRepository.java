package SENAI.Ipiranga.com.bellaAroma.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SENAI.Ipiranga.com.bellaAroma.Model.TipoProduto;


@Repository
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {
    public Optional<TipoProduto> findById(long idTipoProduto);//
    public List<TipoProduto> findByTipoContainingIgnoreCase(String tipo);
    public Optional<TipoProduto> findByCodproduto(String codproduto);
}
