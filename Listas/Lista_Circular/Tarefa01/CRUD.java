package br.unicap.controles;

import br.unicap.controles.excecoes.CadastroInexistenteException;
import br.unicap.controles.excecoes.DadosInvalidosException;

public interface CRUD<T>{
    public abstract void cadastro()throws DadosInvalidosException;
    public abstract void remocao()throws CadastroInexistenteException;
    public abstract void atualizacao()throws CadastroInexistenteException, DadosInvalidosException;
    public abstract T busca()throws CadastroInexistenteException;
}
