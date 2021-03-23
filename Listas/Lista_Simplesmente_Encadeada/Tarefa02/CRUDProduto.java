package br.unicap.cadastros;

import br.unicap.TiposDeDados.*;
import br.unicap.dados.Produto;
import java.util.Scanner;

public class CRUDProduto {

    LSESemRepetidos<Produto> produtos;

    public CRUDProduto() {
        this.produtos = new LSESemRepetidos<>();
    }

    /*
     * CADASTRO
     */
    private Produto cadastroProduto() {
        Scanner in = new Scanner(System.in);
        Produto produto;
        String codigo, descricao;
        double preco;
        int estoque;

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
        return produto;
    }

    public void inserirProdutoNoInicio() {
        Produto produto = cadastroProduto();
        produtos.inserirNoInicio(produto);
    }

    public void inserirProdutoNoFim() {
        Produto produto = cadastroProduto();
        produtos.inserirNoFim(produto);
    }

    /*
     * EXIBIÇÃO
     */
    public void exibirProdutos() {
        produtos.exibirTodos();
    }

    public void exibirProduto() {
        Scanner in = new Scanner(System.in);
        String codigo;
        System.out.println("Digite o código do produto:");
        codigo = in.next();
        in.nextLine();
        produtos.exibirUm(new Produto(codigo));
    }

    /*
     * ALTERAÇÃO
     */
    public void alterarPrecoProduto(Produto produto) {
        Scanner in = new Scanner(System.in);
        System.out.println("Preco: ");
        produto.setPreco(in.nextDouble());
        while (produto.getPreco() == -1) {
            System.out.println("Valor Inválido! Digite Novamente: ");
            produto.setPreco(in.nextDouble());
        }
        produtos.alterar(produto);
    }

    public void atualizarEstoqueProduto(Produto produto) {
        Scanner in = new Scanner(System.in);
        int estoque;
        System.out.println("Quantidade a ser acrescida: ");
        estoque = in.nextInt();

        while (estoque == -1) {
            System.out.println("Valor Inválido! Digite Novamente: ");
            estoque = in.nextInt();
        }
        produto.acrescentarEstoque(estoque);
        produtos.alterar(produto);
    }

    public void registrarVendaProduto(Produto produto) {
        Scanner in = new Scanner(System.in);
        int estoque;
        System.out.println("Quantidade vendida: ");
        estoque = in.nextInt();

        while (estoque == -1) {
            System.out.println("Valor Inválido! Digite Novamente: ");
            estoque = in.nextInt();
        }
        boolean result = produto.retirarDeEstoque(estoque);
        if (result) {
            produtos.alterar(produto);
        } else {
            System.out.println("Sem estoque!");
        }
    }

    /*
     * BUSCA
     */
    public Produto buscarProduto(String codigo) {
        return produtos.buscaObjeto(new Produto(codigo));
    }

    /*
     * REMOÇÃO
     */
    public void removerProdutoNoInicio() {
        produtos.removerNoInicio();
    }

    public void removerProdutoNoFim() {
        produtos.removerNoFim();
    }

    public void removerProduto() {
        Scanner in = new Scanner(System.in);
        String codigo;
        System.out.println("Digite o código do produto a ser Removido:");
        codigo = in.next();
        in.nextLine();

        produtos.remover(new Produto(codigo));
    }
}
