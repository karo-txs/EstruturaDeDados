
package br.unicap.ed1.excecoes;
public class DadosRepetidosException extends Exception{
    
    public DadosRepetidosException(String obj) {
        super(obj+" Já existe!");
    }
}
