package poo.mensagens.usuarios;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import chat.Contato;
import chat.Mensagem;

public class Usuario {

    protected String nome;
    protected int idade;
    // protected String email;
    protected Contato contato;

    public Contato getContato() {
        return contato;
    }

    private boolean idadeVisivel;
    private boolean emailVisivel;

    private List<String> errors = new ArrayList<>();

    private List<Contato> Contatos = new ArrayList<>();

    private Dictionary<Contato, List<String>> mensagensRecebidas = new Hashtable<>();
    //private Dictionary<Contato, List<Mensagem>> mensagensEnviadas = new Hashtable<>();

    public void receberMensagem(Contato remetente, String mensagem){
        // verifica se a chave existe
        // cria o contato se nao tiver
        // adiciona a mensagem na lista desse contato
    }

    public void enviarMensagem(Contato destinatario, String mensagem){
    }

    protected Usuario() { }

    // Factory
    public static Usuario criar(String nome, int idade, String email, boolean idadeVisivel, boolean emailVisivel) {
        var usuario = new Usuario();

        // Validação do usuário
        if (idade < 18)
            usuario.errors.add("Usuário deve ser maior de 18 anos.");
        if (nome == null || nome.isBlank() || nome.length() < 3)
            usuario.errors.add("Nome inválido.");
        if (email == null || email.length() < 5 || !email.contains("@"))
            usuario.errors.add("Email inválido");

        usuario.nome = nome;
        usuario.idade = idade;
        usuario.contato = new Contato(email);
        usuario.idadeVisivel = idadeVisivel;
        usuario.emailVisivel = emailVisivel;

        return usuario;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        if (emailVisivel)
            return this.contato.getEmail();
        return "";
    }

    public int getIdade() {
        if (idadeVisivel)
            return this.idade;
        return 0;
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean contemErro() {
        return errors.size() > 0;
    }

    public List<Contato> getTodosContatos() {
        return Contatos;
    }

    public void setContatos(Contato... contatos) {
        for (Contato contato : contatos) {
            if (Contatos.contains(contato)) {
                continue;
            }
            Contatos.add(contato);
        }
    }

}
