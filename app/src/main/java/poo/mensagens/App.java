package poo.mensagens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.mensagens.usuarios.Admin;
import poo.mensagens.usuarios.Usuario;
import poo.mensagens.usuarios.UsuariosUtility;

public class App {

    public static void main(String[] args) {

        List<Usuario> usuarios = new ArrayList<>();
        List<Usuario> usuariosAtivos = new ArrayList<>();
        List<Usuario> usuariosInativos = new ArrayList<>();
       
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

        ChatServico chatServico = new ChatServico(usuariosAtivos, usuariosInativos);
        chatServico.iniciar();

    }
}
