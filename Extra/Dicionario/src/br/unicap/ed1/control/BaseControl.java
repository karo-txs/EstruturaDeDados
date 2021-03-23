package br.unicap.ed1.control;

import br.unicap.ed1.excecoes.CadastroInexistenteException;
import br.unicap.ed1.excecoes.DadosRepetidosException;

public interface BaseControl<T> {
    public void cadastrar(T obj)throws DadosRepetidosException;
    public void remover(T obj) throws CadastroInexistenteException;
    public T busca(T obj)throws CadastroInexistenteException;
    public void exibir();
}
