package br.unicap.controles;

import br.unicap.TiposDeDados.LDEDecrescenteSemRepetidos;
import br.unicap.dados.Tarefa;
import java.util.Scanner;

public class CadastroTarefas {

    private LDEDecrescenteSemRepetidos<Tarefa> tarefas;

    public CadastroTarefas() {
        this.tarefas = new LDEDecrescenteSemRepetidos<>();
    }

    public void inserirTarefa() {
        Scanner in = new Scanner(System.in);
        int prioridade;
        String descricao;
        Tarefa tarefa = new Tarefa();

        System.out.println("Dados da Tarefa: ");
        System.out.print("Descricao: ");
        descricao = in.nextLine();
        tarefa.setDescricao(descricao);
        while (tarefa.getDescricao().compareTo("XXXX") == 0) {
            System.out.println("Descricao inválida! Digite Novamente: ");
            tarefa.setDescricao(in.nextLine());
        }

        System.out.print("Prioridade: ");
        prioridade = in.nextInt();
        tarefa.setPrioridade(prioridade);
        while (tarefa.getPrioridade() == -1) {
            System.out.println("Prioridade inválida! Digite Novamente: (1 a 10)");
            tarefa.setPrioridade(in.nextInt());
        }

        tarefas.inserir(tarefa);
    }

    public void tarefasAnteriores() {
        Scanner in = new Scanner(System.in);
        String descricao;
        Tarefa tarefa = new Tarefa();

        System.out.print("Descricao: ");
        descricao = in.nextLine();
        tarefa.setDescricao(descricao);
        while (tarefa.getDescricao().compareTo("XXXX") == 0) {
            System.out.println("Descricao inválida! Digite Novamente: ");
            tarefa.setDescricao(in.nextLine());
        }

        int qtdeTarefas = tarefas.qtdeAntes(tarefa);
        if (qtdeTarefas == -1) {
            System.out.println("Tarefa não encontrada!");
        } else {
            System.out.println("Quantidade de tarefas a serem executadas antes: " + qtdeTarefas);
        }
    }

    public void executarTarefa() {
        tarefas.removerNoInicio();
    }

    public void cacelarTarefa() {
        Scanner in = new Scanner(System.in);
        String descricao;
        Tarefa tarefa = new Tarefa();

        System.out.print("Descricao: ");
        descricao = in.nextLine();
        tarefa.setDescricao(descricao);
        while (tarefa.getDescricao().compareTo("XXXX") == 0) {
            System.out.println("Descricao inválida! Digite Novamente: ");
            tarefa.setDescricao(in.nextLine());
        }

        tarefas.remover(tarefa);
    }

    public void exibirTarefasPorPrioridade() {
        Scanner in = new Scanner(System.in);
        int prioridade;
        Tarefa tarefa = new Tarefa();

        System.out.print("Prioridade: ");
        prioridade = in.nextInt();
        tarefa.setPrioridade(prioridade);
        while (tarefa.getPrioridade() == -1) {
            System.out.println("Prioridade inválida! Digite Novamente: (1 a 10)");
            tarefa.setPrioridade(in.nextInt());
        }

        tarefas.exibirPorValor(tarefa);
    }

    public void exibirTodasTarefas() {
        tarefas.exibirTodos();
    }

    public void alterarPrioridade() {
        Scanner in = new Scanner(System.in);
        int prioridade;
        String descricao;
        Tarefa tarefa = new Tarefa();

        System.out.println("Dados da Tarefa: ");
        System.out.print("Descricao: ");
        descricao = in.nextLine();
        tarefa.setDescricao(descricao);
        while (tarefa.getDescricao().compareTo("XXXX") == 0) {
            System.out.println("Descricao inválida! Digite Novamente: ");
            tarefa.setDescricao(in.nextLine());
        }

        Tarefa busca = tarefas.buscaObj(tarefa);
        if (busca != null) {
            System.out.print("Nova Prioridade: ");
            prioridade = in.nextInt();
            while (prioridade<=0 || prioridade>10) {
                System.out.println("Prioridade inválida! Digite Novamente: (1 a 10)");
                prioridade = in.nextInt();
            }
            if(busca.getPrioridade()!=prioridade){
                busca = tarefas.retirarObj(busca);
                busca.setPrioridade(prioridade);
                tarefas.inserir(busca);
                
            }else{
                System.out.println("Prioridade Mantida. Sem Alteracao!");
            }
        } else {
            System.out.println("Tarefa não encontrada!");
        }

    }

}
