package br.unicap.TestaLista;

import br.unicap.cadastros.CRUDProduto;
import br.unicap.dados.Produto;
import java.util.Scanner;

public class AplicacaoProdutos2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CRUDProduto loja = new CRUDProduto();
        char op, op2;
        Produto produto;
        String codigo;

        do {
            menuOpcoes();
            System.out.println("Informe a opção: ");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '1':
                    loja.inserirProdutoNoInicio();
                    break;
                case '2':
                    loja.inserirProdutoNoFim();
                    break;
                case '3':
                    loja.removerProdutoNoInicio();
                    break;
                case '4':
                    loja.removerProdutoNoFim();
                    break;
                case '5':
                    loja.exibirProdutos();
                    break;
                case '6':
                    loja.exibirProduto();
                    break;
                case '7':
                    System.out.println("Digite o código do produto a ser alterado:");
                    codigo = in.next();
                    in.nextLine();

                    produto = loja.buscarProduto(codigo);
                    if (produto != null) {
                        do {
                            menuAlteracoes();
                            op2 = in.next().charAt(0);
                            switch (op2) {
                                case '1':
                                    loja.alterarPrecoProduto(produto);
                                    break;
                                case '2':
                                    loja.atualizarEstoqueProduto(produto);
                                    break;
                                case '3':
                                    loja.registrarVendaProduto(produto);
                                    break;
                                case '0':
                                    System.out.println("Retornando...");
                                    break;
                            }
                        } while (op2 != '0');
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case '8':
                    loja.removerProduto();
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
        System.out.println("[1] - Inserir no início da lista\n"
                + "[2] - Inserir no final da lista\n"
                + "[3] - Remover Produto no início da lista\n"
                + "[4] - Remover Produto no final da lista\n"
                + "[5] - Exibir todos os Produtos da lista\n"
                + "[6] - Exibir dados de um Produto da lista\n"
                + "[7] - Alterar dados de um Produto da lista\n"
                + "[8] - Remover um Produto da lista\n"
                + "[0] - Sair do programa");
    }

    public static void menuAlteracoes() {
        System.out.println("[1] - Alterar Preco\n"
                + "[2] - Alterar Estoque\n"
                + "[3] - Realizar venda\n"
                + "[0] - Retornar");
    }
}
