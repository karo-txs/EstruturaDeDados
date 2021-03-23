package br.unicap.ed1.control;

import br.unicap.TiposDeDados.LDECCrescenteSemRepetidos;
import br.unicap.ed1.excecoes.CadastroInexistenteException;
import br.unicap.ed1.excecoes.DadosInvalidosException;
import br.unicap.ed1.excecoes.DadosRepetidosException;
import br.unicap.ed1.model.Termo;
import br.unicap.ed1.validacao.ValidaDados;

public class Dicionario implements BaseControl<Letra> {

    private LDECCrescenteSemRepetidos<Letra> letras;

    public Dicionario() {
        letras = new LDECCrescenteSemRepetidos<>();
    }

    public void cadastrarTermo(String nome, String descricao) throws DadosRepetidosException, DadosInvalidosException {
        if(nome.equals("")|| descricao.equals("") || !ValidaDados.validaNome(nome)){
            throw new DadosInvalidosException("Nome");
        }
        Termo termo = new Termo(nome,descricao);
        
        Letra letra = new Letra(termo.getNome().substring(0, 1));
        Letra buscaLetra = letras.buscaObj(letra);

        if (buscaLetra == null) {
            this.cadastrar(letra);
            buscaLetra = letra;
        }
        buscaLetra.cadastrar(termo);
    }

    @Override
    public void cadastrar(Letra novaLetra) throws DadosRepetidosException {
        letras.inserirOrdenado(novaLetra);
    }

    @Override
    public Letra busca(Letra letra) throws CadastroInexistenteException {
        Letra busca = letras.buscaObj(letra);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Letra");
        }
    }

    @Override
    public void remover(Letra letra) throws CadastroInexistenteException {
        if (!letras.remover(letra)) {
            throw new CadastroInexistenteException("Letra");
        }
    }

    public void removerTermo(Termo termo) throws CadastroInexistenteException {
        Letra letra = this.busca(new Letra(termo.getNome().substring(0, 1)));
        letra.remover(termo);
        if (letra.getTermos().isEmpty()) {
            this.remover(letra);
        }
    }

    public void editarTermo(Termo termo) throws CadastroInexistenteException, DadosInvalidosException {
        if(termo.getDescricao().equals("")){
            throw new DadosInvalidosException("Descriçao");
        }
        Letra letra = new Letra(termo.getNome().substring(0, 1));
        Termo busca = this.busca(letra).busca(termo);

        busca.setDescricao(termo.getDescricao());
        System.out.println("Descrição do termo atualizada com sucesso!");
    }

    public LDECCrescenteSemRepetidos<Termo> exibirTodos() {
        LDECCrescenteSemRepetidos<Termo> todosTermos = new LDECCrescenteSemRepetidos<>();

        int tam = letras.size();
        for (int i = 0; i < tam; i++) {
            Letra atual = letras.get(i);
            for (int j = 0; j < atual.getTermos().size(); j++) {
                todosTermos.inserirOrdenado(atual.getTermos().get(j));
            }
        }
        return todosTermos;
    }

    public LDECCrescenteSemRepetidos<Termo> exibirTodosPorLetra(String letra) throws CadastroInexistenteException {
        Letra busca = this.busca(new Letra(letra));

        LDECCrescenteSemRepetidos<Termo> todosTermos = new LDECCrescenteSemRepetidos<>();

        for (int j = 0; j < busca.getTermos().size(); j++) {
            todosTermos.inserirOrdenado(busca.getTermos().get(j));
        }

        return todosTermos;
    }

    public LDECCrescenteSemRepetidos<Letra> todasLetras() {
        return this.letras;
    }

    @Override
    public void exibir() {
        int tam = letras.size();
        for (int i = 0; i < tam; i++) {
            letras.get(i).exibir();
        }
    }

    public void exibirUmTermo(Termo termo) throws CadastroInexistenteException {
        Letra letra = new Letra(termo.getNome().substring(0, 1));
        Termo busca = this.busca(letra).busca(termo);
        System.out.println(busca);
    }
}
