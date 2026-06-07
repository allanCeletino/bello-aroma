package SENAI.Ipiranga.com.bellaAroma.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//marca, codrpoduto,tipo

@Entity
@Table(name = "tipoproduto")

public class TipoProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTipoProduto;
	private String tipo;
	
	private String marca;
	private String codproduto;

 	@OneToMany(mappedBy = "tipoproduto", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tipoproduto")
    private List<Produto> produto;//

	public long getIdTipoProduto() {
		return idTipoProduto;
	}

	public void setIdTipoProduto(long idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodproduto() {
		return codproduto;
	}

	public void setCodproduto(String codproduto) {
		this.codproduto = codproduto;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}