package br.unicap.controles;

import br.unicap.TiposDeDados.LDESemRepetidos;
import br.unicap.dados.Pessoa;
import java.util.Scanner;

public class ControleAcessoAdvogados {

    private LDESemRepetidos<Pessoa> pessoas;

    public ControleAcessoAdvogados() {
        this.pessoas = new LDESemRepetidos<>();
    }

    public void cadastro() {
        Scanner in = new Scanner(System.in);
        String nome, rg;
        Pessoa pessoa;

        System.out.println("Dados do Contato: ");
        System.out.print("Nome: ");
        nome = in.nextLine();
        pessoa = new Pessoa(nome);
        while (pessoa.getNome().compareTo("XXXX") == 0) {
            System.out.println("Nome inválido! Digite Novamente: ");
            pessoa.setNome(in.nextLine());
        }

        System.out.print("RG: ");
        rg = in.nextLine();
        pessoa.setRg(rg);
        while (pessoa.getRg().compareTo("XXXX") == 0) {
            System.out.println("RG inválido! Digite Novamente: ");
            pessoa.setRg(in.nextLine());
        }

        pessoas.inserirNoFim(pessoa);
    }

    public void exibirPessoas() {
        pessoas.exibirTodos();
    }

    public void verificarPessoa() {
        Scanner in = new Scanner(System.in);
        String rg;
        Pessoa pessoa = new Pessoa();
        System.out.print("Informe o RG: ");
        rg = in.nextLine();
        pessoa.setRg(rg);
        while (pessoa.getRg().compareTo("XXXX") == 0) {
            System.out.println("RG inválido! Digite Novamente: ");
            pessoa.setRg(in.nextLine());
        }

        Pessoa busca = pessoas.buscaObjeto(pessoa);
        if (busca != null) {
            System.out.println("Pessoa No predio: " + busca);
        } else {
            System.out.println("Pessoa não está no Predio!");
        }
    }

    public void quantidadePessoasNoPredio() {
        System.out.println("Quantidade de Pessoas no Predio: " + pessoas.size());
    }

    public void cancelarRegistro() {
        pessoas.removerNoFinal();
    }

    public void removerPessoa() {
        Scanner in = new Scanner(System.in);
        String rg;
        Pessoa pessoa = new Pessoa();
        System.out.print("Informe o RG: ");
        rg = in.nextLine();
        pessoa.setRg(rg);
        while (pessoa.getRg().compareTo("XXXX") == 0) {
            System.out.println("RG inválido! Digite Novamente: ");
            pessoa.setRg(in.nextLine());
        }

        pessoas.remover(pessoa);
    }

}
