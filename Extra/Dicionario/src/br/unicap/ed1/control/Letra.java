package br.unicap.ed1.control;

import br.unicap.TiposDeDados.LDECCrescenteSemRepetidos;
import br.unicap.ed1.excecoes.CadastroInexistenteException;
import br.unicap.ed1.excecoes.DadosRepetidosException;
import br.unicap.ed1.model.Termo;

public class Letra implements Comparable<Letra>, BaseControl<Termo> {
    
    private String letra;
    private LDECCrescenteSemRepetidos<Termo> termos;
    
    public Letra(String letra){
        this.letra=letra;
        this.termos = new LDECCrescenteSemRepetidos<>();
    }
    
    @Override
    public void cadastrar(Termo novoTermo) throws DadosRepetidosException {
        boolean inserido =  termos.inserirOrdenado(novoTermo);
        if(!inserido){
            throw new DadosRepetidosException("Termo");
        }
    }
    
    @Override
    public void remover(Termo termo) throws CadastroInexistenteException{
        if(!termos.remover(termo)){
            throw new CadastroInexistenteException("Termo");
        }
    }
    
    @Override
    public Termo busca(Termo obj) {
        return termos.buscaObj(obj);
    }
    
    @Override
    public void exibir() {
        termos.exibirTodos();
    }
    
    //Gets e Sets
    public String getLetra() {
        return letra.toUpperCase();
    }

    public LDECCrescenteSemRepetidos<Termo> getTermos() {
        return termos;
    }
    
    @Override
    public int compareTo(Letra t) {
       return this.letra.compareToIgnoreCase(t.letra);
    }
}
