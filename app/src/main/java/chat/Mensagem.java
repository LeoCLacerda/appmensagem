package chat;

import poo.mensagens.usuarios.Usuario;

public class Mensagem {
    private Usuario destinatario;
    private Usuario remetente;
    private String mensagem;
    
    public Mensagem(Usuario destinatario, Usuario remetente, String mensagem) {
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.mensagem = mensagem;
    }

    public void enviar(){
        remetente.receberMensagem(this.destinatario.getContato(), this.mensagem);
    }
}
