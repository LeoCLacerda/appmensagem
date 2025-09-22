package poo.mensagens.usuarios;

import java.util.List;

public class UsuariosUtility {

    public static void adicionar(
            List<Usuario> listaUsuarios,
            List<Usuario> usuariosAtivos,
            List<Usuario> usuariosInativos,
            Usuario... usuarios) {

        for (var usuario : usuarios) {
            listaUsuarios.add(usuario);
            if (usuario.contemErro()) {
                usuariosInativos.add(usuario);
            } else {
                usuariosAtivos.add(usuario);
            }
        }
    }
}
