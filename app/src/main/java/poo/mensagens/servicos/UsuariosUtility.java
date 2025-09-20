package poo.mensagens.servicos;

import java.util.List;

import poo.mensagens.config.Usuario;

public class UsuariosUtility {

    public static void adicionar(
        List<Usuario> listaUsuarios, 
        List<Usuario> usuariosAtivos,
        List<Usuario> usuariosInativos,
        Usuario... usuarios) {
        
        for(var usuario : usuarios){
            listaUsuarios.add(usuario);
            if(usuario.contemErro()){
                usuariosInativos.add(usuario);
            }
            else {
                usuariosAtivos.add(usuario);
            }
        }
    }
    
}
