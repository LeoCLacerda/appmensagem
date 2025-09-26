package poo.mensagens;

import java.util.List;
import java.util.Scanner;

import poo.mensagens.usuarios.Usuario;
import chat.Mensagem;

public class ChatServico {

    private List<Usuario> usuariosAtivos;
    private List<Usuario> usuariosInativos;

    public ChatServico(List<Usuario> usuariosAtivos, List<Usuario> usuariosInativos) {
        this.usuariosAtivos = usuariosAtivos;
        this.usuariosInativos = usuariosInativos;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean sairPrograma = false;

        while (!sairPrograma) {
            // login
            Usuario usuarioLogado = null;
            while (usuarioLogado == null && !sairPrograma) {
                System.out.print("Digite seu email para login (ou 'exit' para encerrar): ");
                String email = scanner.nextLine().trim();
                if (email.equalsIgnoreCase("exit")) {
                    sairPrograma = true;
                    break;
                }

                for (Usuario u : usuariosAtivos) {
                    if (u.getContato().getEmail().equalsIgnoreCase(email)) {
                        usuarioLogado = u;
                        break;
                    }
                }

                if (usuarioLogado == null && !sairPrograma) {
                    System.out.println("Email não encontrado ou usuário inativo. Tente novamente.\n");
                }
            }

            if (sairPrograma) break;

            System.out.println("\nBem-vindo(a), " + usuarioLogado.getNome() + "!\n");

            // comandos possíveis no long-chat
            while (usuarioLogado != null && !sairPrograma) {
                System.out.print(usuarioLogado.getNome() + " > "); // prompt tipo shell
                String comando = scanner.nextLine().trim();

                if (comando.equalsIgnoreCase(">exit")) {
                    System.out.println("Encerrando programa.");
                    sairPrograma = true;
                    break;
                } else if (comando.equalsIgnoreCase(">logout")) {
                    System.out.println("Você foi deslogado(a).\n");
                    usuarioLogado = null;
                    break;
                } else if (comando.equalsIgnoreCase(">see-history")) {
                    usuarioLogado.mostrarHistorico();
                } else if (comando.equalsIgnoreCase(">see-users")) {
                    listarUsuarios();
                } else if (comando.toLowerCase().startsWith(">long-chat with ")) {
                    String nomeDest = comando.substring(15).trim();
                    Usuario destinatario = null;
                    for (Usuario u : usuariosAtivos) {
                        if (u.getNome().equalsIgnoreCase(nomeDest)) {
                            destinatario = u;
                            break;
                        }
                    }

                    if (destinatario != null) {
                        System.out.print("Digite sua mensagem: ");
                        String texto = scanner.nextLine();
                        Mensagem mensagem = new Mensagem(destinatario, usuarioLogado, texto);
                        mensagem.enviar();
                        System.out.println("Mensagem enviada para " + destinatario.getNome() + ".\n");
                    } else {
                        System.out.println("Usuário não encontrado ou inativo.\n");
                    }
                } else {
                    System.out.println("Comando inválido. Tente novamente.\n");
                }
            }
        }

        scanner.close();
    }

    private void listarUsuarios() {
        System.out.println("\n=== Usuários Inativos ===");
        for (Usuario u : usuariosInativos) {
            System.out.println(u.getNome());
        }
        System.out.println("\n=== Usuários Ativos ===");
        for (Usuario u : usuariosAtivos) {
            System.out.println(u.getNome());
        }
        System.out.println();
    }
}

