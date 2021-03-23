package br.unicap.controles;

import br.unicap.controles.excecoes.CadastroInexistenteException;
import br.unicap.controles.validacao.ValidaDados;
import br.unicap.TiposDeDados.LSEC;
import br.unicap.controles.excecoes.DadosInvalidosException;
import br.unicap.dados.Aluno;
import java.util.Scanner;

public class Turma implements CRUD<Aluno>, Comparable<Turma> {
    
    private String codigo;
    private LSEC<Aluno> alunos;
    
    public Turma(String codigo) {
        alunos = new LSEC<>();
        this.codigo = codigo;
    }
    
    public void cadastro(Aluno obj) {
        alunos.inserirNoFim(obj);
    }
    
    @Override
    public void cadastro() throws DadosInvalidosException {
        Scanner in = new Scanner(System.in);
        String mat, nome, media, faltas;
        Aluno a;
        
        System.out.print("Matricula (4 digitos numericos): ");
        mat = in.next();in.nextLine(); 
        if (ValidaDados.validaMatricula(mat)) {
            a = new Aluno(mat);
        } else {
            throw new DadosInvalidosException("Matricula");
        }
        
        System.out.print("Nome: ");
        nome = in.nextLine(); 
        if (ValidaDados.validaNome(nome)) {
            a.setNome(nome);
        } else {
            throw new DadosInvalidosException("Nome");
        }
        
        System.out.print("Media: ");
        media = in.next(); in.nextLine();
        if (ValidaDados.validaMedia(media)) {
            a.setMediaFinal(Double.parseDouble(media));
        } else {
            throw new DadosInvalidosException("Media");
        }
        
        System.out.print("Qtde faltas: ");
        faltas = in.next();
        if (ValidaDados.validaFaltas(faltas)) {
            a.setQtdeFaltas(Integer.parseInt(faltas));
        } else {
            throw new DadosInvalidosException("Quantidade de Faltas");
        }
        
        this.cadastro(a);
    }
    
    @Override
    public void remocao() throws CadastroInexistenteException {
        Scanner in = new Scanner(System.in);
        System.out.println("Matricula: ");
        alunos.remover(new Aluno(in.next()));
    }
    
    @Override
    public Aluno busca() throws CadastroInexistenteException {
        Scanner in = new Scanner(System.in);
        System.out.println("Matricula: ");
        return this.busca(new Aluno(in.next()));
    }
    
    public Aluno busca(Aluno obj) throws CadastroInexistenteException {
        Aluno busca = alunos.buscaObjeto(obj);
        if (busca != null) {
            return busca;
        } else {
            throw new CadastroInexistenteException("Aluno");
        }
    }
    
    private void atualizarMedia(Aluno aluno) throws CadastroInexistenteException, DadosInvalidosException {
        Scanner in = new Scanner(System.in);
        String media;
        
        System.out.print("Nova média: ");
        media = in.next();
        if (ValidaDados.validaMedia(media)) {
            aluno.setMediaFinal(Double.parseDouble(media));
        } else {
            throw new DadosInvalidosException("Media");
        }
        System.out.println("Atualizado com sucesso!");
    }
    
    private void alterarFaltas(Aluno aluno) throws CadastroInexistenteException, DadosInvalidosException {
        Scanner in = new Scanner(System.in);
        String faltas;
        
        char opc;
        do {
            System.out.println("*** Abono de Faltas ***\n"
                    + "[1] - Acrescentar\n"
                    + "[2] - Retirar\n"
                    + "[0] - Retornar");
            opc = in.next().charAt(0);
            switch (opc) {
                case '1':
                    System.out.print("Quantidade de faltas: ");
                    faltas = in.next();
                    if (ValidaDados.validaFaltas(faltas)) {
                        aluno.somarFalta(Integer.parseInt(faltas));
                    } else {
                        throw new DadosInvalidosException("Quantidade de Faltas");
                    }
                    System.out.println("Atualizado com sucesso!");
                    break;
                case '2':
                    System.out.print("Quantidade de faltas: ");
                    faltas = in.next();
                    if (ValidaDados.validaFaltas(faltas) && Integer.parseInt(faltas)<=aluno.getQtdeFaltas()) {
                        aluno.subtrairFalta(Integer.parseInt(faltas));
                    } else {
                        throw new DadosInvalidosException("Quantidade de Faltas");
                    }
                    break;
                case '0':
                    System.out.println("Retornando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while (opc != '0');
        
    }
    
    @Override
    public void atualizacao() throws CadastroInexistenteException, DadosInvalidosException {
        Scanner in = new Scanner(System.in);
        Aluno buscaA = this.busca();
        char opc;
        do {
            System.out.println("[1] - Alterar Media\n"
                    + "[2] - Alterar faltas\n"
                    + "[0] - Retornar");
            opc = in.next().charAt(0);
            switch (opc) {
                case '1':
                    this.atualizarMedia(buscaA);
                    break;
                case '2':
                    this.alterarFaltas(buscaA);
                    break;
                case '0':
                    System.out.println("Retornando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opc != '0');
    }
    
    public boolean ehIgual(Turma t2){
        return alunos.ehIgual(t2.getAlunos());
    }
    
    public void listarTodos() {
        alunos.exibitTodos();
    }
    
    public void exibirAluno() throws CadastroInexistenteException {
        Aluno buscaA = this.busca();
        System.out.println("matricula=" + buscaA.getMatricula() + ", nome=" + buscaA.getNome() + ", mediaFinal="
                + buscaA.getMediaFinal() + ", qtdeFaltas=" + buscaA.getQtdeFaltas());
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public LSEC<Aluno> getAlunos() {
        return alunos;
    }
    
    public void setAlunos(LSEC<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    @Override
    public int compareTo(Turma o) {
        return this.codigo.compareToIgnoreCase(o.codigo);
    }
    
    @Override
    public String toString() {
        return "Turma{" + "codigo=" + codigo + ", Qtde alunos=" + alunos.size() + '}';
    }
    
}
