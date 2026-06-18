package SENAI.Ipiranga.com.bellaAroma.Model;

public class UsuarioLogin {
    
    private long id; // Nome simplificado para bater com o Get/Set
    private String nome;
    private String usuario;
    private String senha;
    private String token;
    private String foto;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        // Corrigido para atribuir a variável correta
        this.id = id; 
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

