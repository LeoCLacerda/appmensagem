package poo.mensagens.config;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    protected String nome;
    protected int idade;
    protected String email;

    private boolean idadeVisivel;
    private boolean emailVisivel;

    private List<String> errors = new ArrayList<>();

    public Usuario() { }

    // Factory
    public static Usuario criar(String nome, int idade, String email, boolean idadeVisivel, boolean emailVisivel) {
        var usuario = new Usuario();

        // Validação do usuário
        if(idade < 18)
            usuario.errors.add("Usuário deve ser maior de 18 anos.");
        if(nome == null || nome.isBlank() || nome.length() < 3)
            usuario.errors.add("Nome inválido.");
        if(email == null || email.length() < 5 || !email.contains("@"))
            usuario.errors.add("Email inválido");
        
        usuario.nome = nome;
        usuario.idade = idade;
        usuario.email = email;
        usuario.idadeVisivel = idadeVisivel;
        usuario.emailVisivel = emailVisivel;

        return usuario;
    }

    public String getNome() { return this.nome; }
    public String getEmail() { 
        if(emailVisivel) return this.email; 
        return "";
    }

    public int getIdade() { 
        if(idadeVisivel) return this.idade;
        return 0;
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean contemErro() {
        return errors.size() > 0;
    }
}
