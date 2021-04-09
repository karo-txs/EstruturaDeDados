package arvoreRB;

public class Main {

    public static void main(String[] args) {
        ArvorePretoVermelho a = new ArvorePretoVermelho();

        a.inserir(500);
        a.inserir(250);
        a.inserir(750);
        a.inserir(200);
        a.deletar(500);
        a.inserir(800);
        a.inserir(900);
        a.inserir(600);
        a.inserir(780);
        a.inserir(790);
        a.deletar(790);
        a.inserir(1000);
        a.inserir(850);
        a.inserir(880);
        
        
//        a.inserir(150);
//        a.inserir(100);
//        a.inserir(50);
//        a.inserir(0);
//        a.inserir(151);
//        a.inserir(152);
//        a.inserir(153);
//        a.inserir(154);
//        a.inserir(249);
//        a.inserir(248);
//        a.inserir(247);
//        a.inserir(246);
//        a.inserir(245);

//------------------------------
        BinaryTreePrinter<No> p = new BinaryTreePrinter<>(a);
        p.imprimir(System.out);
        System.out.println("\n\nDEPOIS: \n\n");

        
        a.deletar(6545);
        
//        a.deletar(780);

//        a.deletar(247);
//        a.deletar(151);
//        a.deletar(0);
//        a.deletar(246);
//        a.deletar(200);
//        a.deletar(245);
//        a.deletar(500);
//        a.deletar(150);
//        a.deletar(153);
//        a.deletar(250);
//        a.deletar(248);
//        a.deletar(249);
//        a.deletar(50);
//        a.deletar(100);
//        a.deletar(152);
//        a.deletar(750);
        p.imprimir(System.out);
    }

}
