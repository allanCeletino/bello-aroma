package SENAI.Ipiranga.com.bellaAroma.Repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SENAI.Ipiranga.com.bellaAroma.Model.Vendas;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long> {
    public Optional<Vendas> findByIdVendas(long idVendas);
    public Optional<Vendas> findByValor(BigDecimal valor);
   
    
}
