package br.unicap.cadastros;

import br.unicap.TiposDeDados.LSEOrdenada;
import br.unicap.dados.Contato;
import java.util.Scanner;

public class Agenda implements Cloneable{

    private LSEOrdenada<Contato> contatos;

    public Agenda() {
        this.contatos = new LSEOrdenada<>();
    }

    public void adicionarContato() {
        Scanner in = new Scanner(System.in);
        String nome, telefone, email;
        Contato contato;

        System.out.println("Dados do Contato: ");
        System.out.print("Nome: ");
        nome = in.nextLine();
        contato = new Contato(nome);
        while (contato.getNome().compareTo("XXXX") == 0) {
            System.out.println("Nome inválido! Digite Novamente: ");
            contato.setNome(in.nextLine());
        }

        System.out.print("Telefone: ");
        telefone = in.nextLine();
        contato.setTelefone(telefone);
        while (contato.getTelefone().compareTo("XXXX") == 0) {
            System.out.println("Telefone inválido! Digite Novamente: ");
            contato.setTelefone(in.nextLine());
        }

        System.out.print("Email: ");
        email = in.nextLine();
        contato.setEmail(email);
        while (contato.getEmail().compareTo("XXXX") == 0) {
            System.out.println("Email inválido! Digite Novamente: ");
            contato.setEmail(in.nextLine());
        }

        contatos.inserirOrdenado(contato);
    }

    public void removerContato() {
        Scanner in = new Scanner(System.in);
        String nome;
        Contato contato;

        System.out.print("Nome: ");
        nome = in.nextLine();
        contato = new Contato(nome);
        while (contato.getNome().compareTo("XXXX") == 0) {
            System.out.println("Nome inválido! Digite Novamente: ");
            contato.setNome(in.nextLine());
        }

        contatos.remover(contato);
    }

    public void exibirAgenda() {
        contatos.exibirTodos();
    }

    public void exibirUm() {
        Scanner in = new Scanner(System.in);
        String nome;
        Contato contato;

        System.out.print("Nome: ");
        nome = in.nextLine();
        contato = new Contato(nome);
        while (contato.getNome().compareTo("XXXX") == 0) {
            System.out.println("Nome inválido! Digite Novamente: ");
            contato.setNome(in.nextLine());
        }

        contatos.exibirUm(contato);
    }

    public void alteracao() {
        Scanner in = new Scanner(System.in);
        String nome, telefone, email;
        char opc = '1';
        Contato contato;

        System.out.print("Nome: ");
        nome = in.nextLine();
        contato = new Contato(nome);
        while (contato.getNome().compareTo("XXXX") == 0) {
            System.out.println("Nome inválido! Digite Novamente: ");
            contato.setNome(in.nextLine());
        }

        Contato busca = contatos.buscaObjeto(contato);
        if (busca != null) {
            do {
                this.menuAlteracao();
                opc = in.next().charAt(0);

                switch (opc) {
                    case '1':
                        System.out.print("Novo telefone: ");
                        telefone = in.next();in.nextLine();
                        busca.setTelefone(telefone);
                        while (busca.getTelefone().compareTo("XXXX") == 0) {
                            System.out.println("Telefone inválido! Digite Novamente: ");
                            busca.setTelefone(in.nextLine());
                        }
                        contatos.alterar(busca);
                        break;
                    case '2':
                        System.out.print("Novo email: ");
                        email = in.next();in.nextLine();
                        busca.setEmail(email);
                        while (busca.getNome().compareTo("XXXX") == 0) {
                            System.out.println("Nome inválido! Digite Novamente: ");
                            busca.setNome(in.nextLine());
                        }
                        
                        contatos.alterar(busca);
                        break;
                    case '0':
                        System.out.println("Retornando...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } while (opc != '0');

        } else {
            System.out.println("Contato inexistente!");
        }
    }
    
    @Override
    public Agenda clone() throws CloneNotSupportedException {
        return (Agenda) super.clone();
    }

    private void menuAlteracao() {
        System.out.println("Alterações: "
                + "\n[1] - Alterar Telefone"
                + "\n[2] - Alterar Email"
                + "\n[3] - Retornar");
    }

    public LSEOrdenada<Contato> getContatos() {
        return contatos;
    }

}
