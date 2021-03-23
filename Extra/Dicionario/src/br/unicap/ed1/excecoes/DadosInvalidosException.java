
package br.unicap.ed1.excecoes;
public class DadosInvalidosException extends Exception{
    
    public DadosInvalidosException(String obj) {
        super(obj+" Inválido(a)!");
    }
}
