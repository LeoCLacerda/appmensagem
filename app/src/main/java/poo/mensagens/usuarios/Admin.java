package poo.mensagens.usuarios;

import chat.Contato;

public class Admin extends Usuario{

    public static Admin criar(String nome, int idade, String email){
        var admin = new Admin();
        admin.nome = nome;
        admin.idade = idade;
        admin.contato = new Contato(email);
        return admin;
    } 

    // pode enviar para qualqer usuario se for admin
    // deve receber a lista de todos os usuarios para conseguir fazer isso
    @Override
    public void enviarMensagem(Contato destinatario, String mensagem) {
        super.enviarMensagem(destinatario, mensagem);
    }
}
