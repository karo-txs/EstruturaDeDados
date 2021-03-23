package arvoreavl;
public class No {
    private int chave;
    private No esquerda;
    private No direita;
    private No pai;
    private int fator;

    public No(int chave) {
        this.chave = chave;
    }

    public int getChave() {
        return chave;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getEsquerda() {
        return (T) esquerda;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getDireita() {
        return (T) direita;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getPai() {
        return pai;
    }
    
    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getFator() {
        return fator;
    }

    public void setFator(int fator) {
        this.fator = fator;
    }
    
    
}
