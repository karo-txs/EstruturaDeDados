package br.unicap.controles;

import br.unicap.controles.excecoes.CadastroInexistenteException;
import br.unicap.TiposDeDados.LSEC;
import br.unicap.controles.excecoes.DadosInvalidosException;
import br.unicap.controles.validacao.ValidaDados;
import java.util.Scanner;

public class CadastroTurma implements CRUD<Turma> {

    private LSEC<Turma> turmas;

    public CadastroTurma() {
        turmas = new LSEC<>();
    }

    public void cadastro(Turma obj) {
        turmas.inserirNoFim(obj);
    }

    @Override
    public void cadastro() throws DadosInvalidosException {
        Scanner in = new Scanner(System.in);
        Turma t;
        System.out.println("Codigo da Turma (Ex.: INF123): ");
        String cod = in.next();
        if (ValidaDados.validaCodigoTurma(cod)) {
            t = new Turma(cod);
        } else {
            throw new DadosInvalidosException("Codigo");
        }

        turmas.inserirNoFim(t);
    }

    @Override
    public void remocao() throws CadastroInexistenteException {
        Scanner in = new Scanner(System.in);
        System.out.print("Codigo da turma: ");
        String codigo = in.next();
        Turma busca = this.busca(new Turma(codigo));
        turmas.remover(busca);
    }

    @Override
    public void atualizacao() throws CadastroInexistenteException, DadosInvalidosException {
        Scanner in = new Scanner(System.in);
        Turma t = this.busca();

        System.out.print("Novo Codigo da turma: ");
        String cod = in.next();
        if (ValidaDados.validaCodigoTurma(cod)) {
            t.setCodigo(cod);
        } else {
            throw new DadosInvalidosException("Matricula");
        }
    }

    public Turma busca(Turma obj) throws CadastroInexistenteException {
        Turma busca = turmas.buscaObjeto(obj);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Turma");
        }
    }

    public void listarTurmas() {
        turmas.exibitTodos();
    }

    @Override
    public Turma busca() throws CadastroInexistenteException {
        Scanner in = new Scanner(System.in);
        System.out.println("Codigo: ");
        return this.busca(new Turma(in.next()));
    }

    public void turmasIguais() throws CadastroInexistenteException {
        Turma t1 = this.busca();
        Turma t2 = this.busca();
        String result = t1.ehIgual(t2) ? "Sim" : "Não";
        System.out.println("Turmas iguais: "+result+"!");
    }

}
