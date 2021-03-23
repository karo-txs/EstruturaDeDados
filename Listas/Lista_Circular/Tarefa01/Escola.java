
import br.unicap.controles.excecoes.CadastroInexistenteException;
import br.unicap.controles.CadastroTurma;
import br.unicap.controles.Turma;
import br.unicap.controles.excecoes.DadosInvalidosException;
import java.util.Scanner;

public class Escola {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CadastroTurma cad = new CadastroTurma();
        char opc;

        do {
            menu();
            opc = in.next().charAt(0);
            in.nextLine();
            switch (opc) {
                case '1':
                    Turma busca;
                    try {
                        busca = cad.busca();
                        acessarTurma(busca);
                    } catch (CadastroInexistenteException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case '2':
                    try {
                        cad.cadastro();
                    } catch (DadosInvalidosException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case '3':
                    try {
                        cad.remocao();
                    } catch (CadastroInexistenteException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case '4':
                    cad.listarTurmas();
                    break;
                case '5':
                    try {
                        cad.turmasIguais();
                    } catch (CadastroInexistenteException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case '0':
                    System.out.println("Programa Finalizado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opc != '0');

    }

    public static void menu() {
        System.out.println("*** Controle de Turmas ***\n"
                + "[1] - Acessar Turma\n"
                + "[2] - Cadastrar Turma\n"
                + "[3] - Remover Turma\n"
                + "[4] - Listar Turmas\n"
                + "[5] - Verificar se são Turmas iguais\n"
                + "[0] - Sair");
    }

    public static void menuTurma() {
        System.out.println("*** Turma ***\n"
                + "[1] - Cadastrar Aluno\n"
                + "[2] - Listar Turma\n"
                + "[3] - Aterar dados de um aluno\n"
                + "[4] - Exibir dados de um aluno\n"
                + "[5] - Remover aluno\n"
                + "[0] - Retornar");
    }

    public static void acessarTurma(Turma t) {
        Scanner in = new Scanner(System.in);
        char opc;
        do {
            menuTurma();
            opc = in.next().charAt(0);
            in.nextLine();
            switch (opc) {
                case '1':
                    try {
                        t.cadastro();
                    } catch (DadosInvalidosException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case '2':
                    t.listarTodos();
                    break;
                case '3':
                    try {
                        t.atualizacao();
                    } catch (CadastroInexistenteException | DadosInvalidosException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case '4':
                    try {
                        t.exibirAluno();
                    } catch (CadastroInexistenteException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case '5':
                    try {
                        t.remocao();
                    } catch (CadastroInexistenteException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case '0':
                    System.out.println("Retornando!");
                    break;
                default:
                    System.out.println("Opção inválida!!");
                    break;
            }

        } while (opc != '0');
    }
}
