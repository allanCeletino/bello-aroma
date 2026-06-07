package SENAI.Ipiranga.com.bellaAroma.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario_Login")

public class UsuarioLogin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idLogin;
private String nome;
private String usuario;
private String senha;
private String token;
private String foto;
public long getId() {
	return idLogin;
}
public void setId(long idLogin) {
	this.idLogin = idLogin;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public String getFoto() {
	return foto;
}
public void setFoto(String foto) {
	this.foto = foto;
}




	

}
