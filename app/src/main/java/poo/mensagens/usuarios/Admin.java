package poo.mensagens.usuarios;

public class Admin extends Usuario{

    public static Admin criar(String nome, int idade, String email){
        var admin = new Admin();
        admin.nome = nome;
        admin.idade = idade;
        admin.email = email;
        return admin;
    } 
}
