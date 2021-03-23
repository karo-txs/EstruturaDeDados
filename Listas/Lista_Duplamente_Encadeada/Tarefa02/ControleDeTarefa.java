package br.unicap.TestaLista;

import br.unicap.controles.CadastroTarefas;
import java.util.Scanner;

public class ControleDeTarefa {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        CadastroTarefas tarefasControl = new CadastroTarefas();
        char op;
        System.out.println("### Controle de Tarefas ###");
        do {
            menuOpcoes();
            System.out.println("Informe a opção: ");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '1':
                    tarefasControl.inserirTarefa();
                    break;
                case '2':
                    tarefasControl.tarefasAnteriores();
                    break;
                case '3':
                    tarefasControl.executarTarefa();
                    break;
                case '4':
                    tarefasControl.cacelarTarefa();
                    break;
                case '5':
                    tarefasControl.exibirTarefasPorPrioridade();
                    break;
                case '6':
                    tarefasControl.exibirTodasTarefas();
                    break;
                case '7':
                    tarefasControl.alterarPrioridade();
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
        System.out.println("[1] - Inserir Tarefa\n"
                + "[2] - Quantas Tarefas existem antes\n"
                + "[3] - Executar Tarefa\n"
                + "[4] - Remover Tarefa\n"
                + "[5] - Exibir Tarefas Por Prioridade\n"
                + "[6] - Exibir Todas Tarefas\n"
                + "[7] - Alterar Prioridade\n"
                + "[0] - Sair do programa");
    }
}
