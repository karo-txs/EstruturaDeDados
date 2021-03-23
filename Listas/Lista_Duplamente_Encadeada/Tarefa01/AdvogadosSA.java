package br.unicap.TestaLista;

import br.unicap.controles.ControleAcessoAdvogados;
import java.util.Scanner;

public class AdvogadosSA {
  public static void main(String[] args) throws CloneNotSupportedException{
        Scanner in = new Scanner(System.in);
        ControleAcessoAdvogados controleAcesso = new ControleAcessoAdvogados();
        char op;
        System.out.println("### ADVOGADOS S.A. ###");
        do {
            menuOpcoes();
            System.out.println("Informe a opção: ");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '1':
                    controleAcesso.cadastro();
                    break;
                case '2':
                    controleAcesso.cancelarRegistro();
                    break;
                case '3':
                    controleAcesso.exibirPessoas();
                    break;
                case '4':
                    controleAcesso.verificarPessoa();
                    break;
                case '5':
                    controleAcesso.quantidadePessoasNoPredio();
                    break;
                case '6':
                    controleAcesso.removerPessoa();
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
        System.out.println("[1] - Cadastrar Pessoa\n"
                + "[2] - Cancelar Registro\n"
                + "[3] - Exibir Pessoas\n"
                + "[4] - Verificar se Pessoa está no Predio\n"
                + "[5] - Quantidade de pessoas\n"
                + "[6] - Remover Pessoa\n"
                + "[0] - Sair do programa");
    }
}