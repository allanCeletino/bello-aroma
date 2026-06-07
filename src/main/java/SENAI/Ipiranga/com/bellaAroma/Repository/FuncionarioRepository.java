package SENAI.Ipiranga.com.bellaAroma.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SENAI.Ipiranga.com.bellaAroma.Model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    //pequisa por id
    public Optional<Funcionario> findByIdFuncionario(long idFuncionario);
    //pequisa por nome
    public Optional<Funcionario> findByNomeContainingIgnoreCase(String nome);
    public Optional<Funcionario> findByUsuario(String usuario);
    public List<Funcionario> findByUsuarioContainingIgnoreCase(String usuario);
    //pequisa por numero de pedidos
   public Optional<Funcionario> findByNPedido(String nPedido);
   public Optional<Funcionario> findByStatus(String Status);
}
