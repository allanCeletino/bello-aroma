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
    public Optional<Funcionario> findByUsuario(String usuario);
    public List<Funcionario> findByUsuarioContainingIgnoreCase(String usuario);
    public List<Funcionario> findByNomeContainingIgnoreCase(String nome);
   public Optional<Funcionario> findByNPedido(long nPedido);
  public List<Funcionario> findByStatusContainingIgnoreCase(String status);
   public Optional<Funcionario> findByUsuarioAndSenha(String usuario, String senha);
}

/*package ://ipiranga.com.bellaAroma.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ://ipiranga.com.bellaAroma.Model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    // Opcional: mantém o seu se o nome do atributo no Model for idFuncionario exatamente assim
    public Optional<Funcionario> findByIdFuncionario(long idFuncionario);
    
    // Alterado para List: aceita múltiplos resultados com o mesmo nome
    public List<Funcionario> findByNomeContainingIgnoreCase(String nome);
    
    public Optional<Funcionario> findByUsuario(String usuario);
    public List<Funcionario> findByUsuarioContainingIgnoreCase(String usuario);
    
    public Optional<Funcionario> findByNPedido(long nPedido);
    
    // Alterado para List: aceita múltiplos funcionários "ATIVO" ou "INATIVO"
    public List<Funcionario> findByStatusContainingIgnoreCase(String status);
    
    public Optional<Funcionario> findByUsuarioAndSenha(String usuario, String senha);
}
 */
