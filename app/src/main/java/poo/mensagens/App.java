package poo.mensagens;

import java.util.ArrayList;
import java.util.List;

import poo.mensagens.usuarios.Admin;
import poo.mensagens.usuarios.Usuario;
import poo.mensagens.usuarios.UsuariosUtility;

public class App {

    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Usuario> usuariosAtivos = new ArrayList<>();
    private static List<Usuario> usuariosInativos = new ArrayList<>();

    public static void main(String[] args) {
        // Administradores
        var admin1 = Admin.criar("Emily", 20, "emily@gmail.com");
        var admin2 = Admin.criar("Fran", 20, "fran@gmail.com");
        var admin3 = Admin.criar("João", 20, "joao@gmail.com");
        var admin4 = Admin.criar("Victor", 20, "victor@gmail.com");
        var admin5 = Admin.criar("Leonardo", 20, "leonardo@gmail.com"); 

        var usuario1 = Usuario.criar("Allen", 25, "allen@gmail.com", true, true);
        var usuario2 = Usuario.criar("Mario", 15, "mario@gmail.com", false, false);
        var usuario3 = Usuario.criar("Princesa Peach", 16, "peachgmail.com ", true, true);
        var usuario4 = Usuario.criar("Luigi", 18, "luigi@gmail.com", false, false);

        UsuariosUtility.adicionar(
            usuarios, usuariosAtivos, usuariosInativos,
            admin1, admin2, admin3, admin4, admin5,
            usuario1, usuario2, usuario3, usuario4);

        admin1.setContatos(usuario1.getContato());
        admin1.enviarMensagem(usuario1.getContato(), "oi");
        admin1.enviarMensagem(usuario2.getContato(), "oi"); // vai falhar 

        System.out.println("Usuários Inativos:");
        for (var usuario : usuariosInativos) {
            System.out.println(usuario.getNome());
            System.out.println(String.join("\n", usuario.getErrors()));
        }

        System.out.println("Usuários Ativos:");
        for (var usuario : usuariosAtivos) {
            System.out.println(usuario.getNome());
        }

        System.out.println("Administradores:");
        for (var usuario : usuarios) {
            if(usuario instanceof Admin){
                System.out.println(usuario.getNome());
            }
        }
    }
}
