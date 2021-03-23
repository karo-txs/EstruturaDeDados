package br.unicap.ed1.validacao;

public class ValidaDados {

    public static boolean validaCodigoTurma(String cod) {
        if (cod.length() == 6) {
            String parte1 = cod.substring(0, 3);
            String parte2 = cod.substring(3);
            if (validaNome(parte1) && validaNumero(parte2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validaMatricula(String mat) {
        return validaNumero(mat) && mat.length() ==4;
    }

    public static boolean validaNome(String nome) {
        return nome.replace(" ", "").matches("^[a-zA-Z]*$");
    }

    public static boolean validaNumero(String num) {
        return num.matches("^\\d+$");
    }

    public static boolean validaFaltas(String qtdeFaltas) {
        try {
            int valor = Integer.parseInt(qtdeFaltas);
            return valor >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validaMedia(String media) {
        try {
            double valor = Double.parseDouble(media);
            return valor >= 0 && valor <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
