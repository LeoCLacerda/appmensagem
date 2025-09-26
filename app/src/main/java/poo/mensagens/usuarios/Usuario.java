package poo.mensagens.usuarios;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import chat.Contato;

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

    private Map<Contato, List<String>> mensagensRecebidas = new Hashtable<>(); //Map no lugar de Dictionary para usar o método keySet()

    public void receberMensagem(Contato remetente, String mensagem) {
    //para armazenar no "histórico"
    List<String> historico = mensagensRecebidas.get(remetente);
    if (historico == null) {
        historico = new ArrayList<>();
        mensagensRecebidas.put(remetente, historico);
    }
    historico.add(mensagem);
}

    public void mostrarHistorico() { 
    //permite visualizar o histórico
    System.out.println("Histórico de mensagens de " + nome + ":");
    for (Contato contato : mensagensRecebidas.keySet()) {
        System.out.println("De: " + contato.getEmail());
        for (String msg : mensagensRecebidas.get(contato)) {
            System.out.println("  " + msg);
        }
    }
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
