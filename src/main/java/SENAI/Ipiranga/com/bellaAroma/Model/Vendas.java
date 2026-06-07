package SENAI.Ipiranga.com.bellaAroma.Model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne; // Importante adicionar
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "vendas")
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVendas;
    
    private BigDecimal valor;
    private String formapagamento;
    private BigDecimal comissao;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda = new java.sql.Date(System.currentTimeMillis());

    // Relacionamento com Funcionario
    @ManyToOne
    @JoinColumn(name = "funcionario_id") // Define o nome da coluna no banco
    @JsonIgnoreProperties("vendas")
    private Funcionario funcionario;

    // Relacionamento com Produto
    @ManyToOne
    @JoinColumn(name = "produto_id") // Define o nome da coluna no banco
    @JsonIgnoreProperties("vendas")
    private Produto produto;

    // --- GETTERS E SETTERS (ESSENCIAIS) ---

    public long getIdVendas() {
        return idVendas;
    }
    public void setIdVendas(long idVendas) {
        this.idVendas = idVendas;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public String getFormapagamento() {
        return formapagamento;
    }
    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }
    public BigDecimal getComissao() {
        return comissao;
    }
    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }
    public Date getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    // Faltavam estes dois abaixo:
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}