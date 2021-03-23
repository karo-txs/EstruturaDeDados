package br.unicap.TestaLista;

import br.unicap.cadastros.Agenda;
import java.util.Scanner;

public class GerenciaAgenda {
    public static void main(String[] args) throws CloneNotSupportedException{
        Scanner in = new Scanner(System.in);
        Agenda agenda = new Agenda();
        char op;
        System.out.println("### AGENDINHA ###");
        do {
            menuOpcoes();
            System.out.println("Informe a opção: ");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '1':
                    agenda.adicionarContato();
                    break;
                case '2':
                    agenda.removerContato();
                    break;
                case '3':
                    agenda.exibirAgenda();
                    break;
                case '4':
                    agenda.exibirUm();
                    break;
                case '5':
                    agenda.alteracao();
                    break;
                case '6':
                    Agenda copia = agenda.clone();
                    System.out.println("Agenda Copiada ->"+copia);
                    break;
                case '0':
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != '0');
    }

    public static void menuOpcoes() {
        System.out.println("[1] - Adicionar Contato\n"
                + "[2] - Remover Contato\n"
                + "[3] - Exibir Agenda\n"
                + "[4] - Exibir um contato\n"
                + "[5] - Alterar dados de um contato\n"
                + "[6] - Copiar Agenda\n"
                + "[0] - Sair do programa");
    }
}

