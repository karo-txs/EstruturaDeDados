package br.unicap.dados;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contato implements Comparable<Contato> {

    private String nome;
    private String telefone;
    private String email;

    public Contato() {

    }

    public Contato(String nome) {
        this.setNome(nome);
    }

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.replace(" ", "").matches("^[a-zA-Z]*$")) {
            this.nome = nome;
        } else {
            this.nome = "XXXX";
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone.matches("^\\d+$")) {
            this.telefone = telefone;
        } else {
            this.telefone = "XXXX";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (emailValido(email)) {
            this.email = email;
        } else {
            this.email = "XXXX";
        }
    }

    private boolean emailValido(String email) {
        boolean valido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                valido = true;
            }
        }
        return valido;
    }

    @Override
    public int compareTo(Contato o) {
        return this.nome.compareToIgnoreCase(o.getNome());
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", telefone=" + telefone + ", email=" + email + '}';
    }

}
