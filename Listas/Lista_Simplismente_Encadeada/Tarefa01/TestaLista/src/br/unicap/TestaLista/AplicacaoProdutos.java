package br.unicap.TestaLista;

import br.unicap.TiposDeDados.LSESemRepetidos;
import br.unicap.dados.Produto;
import java.util.Scanner;

public class AplicacaoProdutos {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSESemRepetidos<Produto> lista = new LSESemRepetidos();
        char op, op2;
        Produto produto;
        String codigo, descricao;
        double preco;
        int estoque;

        do {
            menuOpcoes();
            System.out.println("Informe a opção: ");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '1':

                    System.out.println("DADOS DO PRODUTO:");
                    System.out.println("Codigo: ");
                    codigo = in.next();
                    in.nextLine();
                    produto = new Produto(codigo);

                    System.out.println("Descrição: ");
                    descricao = in.nextLine();
                    produto.setDescricao(descricao);
                    while (produto.getDescricao().equalsIgnoreCase("XXXX")) {
                        System.out.println("Valor Inválido! Digite Novamente: ");
                        produto.setDescricao(in.nextLine());
                    }

                    System.out.println("Preco: ");
                    preco = in.nextDouble();
                    produto.setPreco(preco);
                    while (produto.getPreco() == -1) {
                        System.out.println("Valor Inválido! Digite Novamente: ");
                        produto.setPreco(in.nextDouble());
                    }

                    System.out.println("Estoque: ");
                    estoque = in.nextInt();
                    produto.setEstoque(estoque);
                    while (produto.getEstoque() == -1) {
                        System.out.println("Valor Inválido! Digite Novamente: ");
                        produto.setEstoque(in.nextInt());
                    }

                    lista.inserirNoInicio(produto);
                    break;
                case '2':

                    System.out.println("DADOS DO PRODUTO:");
                    System.out.println("Codigo: ");
                    codigo = in.next();
                    in.nextLine();
                    produto = new Produto(codigo);

                    System.out.println("Descrição: ");
                    descricao = in.nextLine();
                    produto.setDescricao(descricao);
                    while (produto.getDescricao().equalsIgnoreCase("XXXX")) {
                        System.out.println("Valor Inválido! Digite Novamente: ");
                        produto.setDescricao(in.nextLine());
                    }

                    System.out.println("Preco: ");
                    preco = in.nextDouble();
                    produto.setPreco(preco);
                    while (produto.getPreco() == -1) {
                        System.out.println("Valor Inválido! Digite Novamente: ");
                        produto.setPreco(in.nextDouble());
                    }

                    System.out.println("Estoque: ");
                    estoque = in.nextInt();
                    produto.setEstoque(estoque);
                    while (produto.getEstoque() == -1) {
                        System.out.println("Valor Inválido! Digite Novamente: ");
                        produto.setEstoque(in.nextInt());
                    }

                    lista.inserirNoFim(produto);
                    break;
                case '3':
                    lista.removerNoInicio();
                    break;
                case '4':
                    lista.removerNoFim();
                    break;
                case '5':
                    lista.exibirTodos();
                    break;
                case '6':
                    System.out.println("Digite o código do produto:");
                    codigo = in.next();
                    in.nextLine();
                    lista.exibirUm(new Produto(codigo));
                    break;
                case '7':
                    System.out.println("Digite o código do produto a ser alterado:");
                    codigo = in.next();
                    in.nextLine();

                    produto = lista.buscaObjeto(new Produto(codigo));
                    if (produto != null) {
                        do {
                            menuAlteracoes();
                            op2 = in.next().charAt(0);
                            switch (op2) {
                                case '1':
                                    System.out.println("Preco: ");
                                    produto.setPreco(in.nextDouble());
                                    while (produto.getPreco() == -1) {
                                        System.out.println("Valor Inválido! Digite Novamente: ");
                                        produto.setPreco(in.nextDouble());
                                    }
                                    lista.alterar(produto);
                                    break;
                                case '2':
                                    System.out.println("Estoque: ");
                                    produto.setEstoque(in.nextInt());
                                    while (produto.getEstoque() == -1) {
                                        System.out.println("Valor Inválido! Digite Novamente: ");
                                        produto.setEstoque(in.nextInt());
                                    }

                                    lista.alterar(produto);
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
                    System.out.println("Digite o código do produto a ser Removido:");
                    codigo = in.next();
                    in.nextLine();

                    lista.remover(new Produto(codigo));
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
                + "[0] - Retornar");
    }
}
