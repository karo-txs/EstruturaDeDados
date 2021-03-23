package br.unicap.dados;
public class Produto implements Comparable<Produto>{
    private final String codigo;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(String codigo){ 
        this.codigo = codigo;
    }
    
    public Produto(String codigo, String descricao, double preco, int estoque) {
        this(codigo);
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }
    
    public void acrescentarEstoque(int qtde){
        this.setEstoque(this.getEstoque()+qtde);
    }
    
    public boolean retirarDeEstoque(int qtde){
        if(this.estoque<qtde){
           return false;
        }else{
            this.setEstoque(this.getEstoque()-qtde);
            return true;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
         if (descricao.replace(" ", "").matches("^[a-zA-Z]*$")) {
            this.descricao = descricao;
        } else {
            this.descricao = "XXXX";
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            this.preco = -1;
        }
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque >= 0) {
            this.estoque = estoque;
        } else {
            this.estoque = -1;
        }
    }

    @Override
    public int compareTo(Produto p) {
        return this.codigo.compareToIgnoreCase(p.getCodigo());
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", estoque=" + estoque + '}';
    }
}
