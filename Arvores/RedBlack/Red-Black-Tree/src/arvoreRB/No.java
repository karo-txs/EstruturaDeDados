package arvoreRB;

public class No {

    private int chave;

    private No esquerda;
    private No direita;
    private No pai;
    private boolean isRed;

    public No(int chave) {
        this.chave = chave;
        this.esquerda = null;
        this.direita = null;
        this.isRed = true;
        this.pai = null;
    }


    @SuppressWarnings("unchecked")
    public <T extends No> T getEsquerda() {
        return (T) esquerda;
    }

    public void setEsquerda(No n) {
        this.esquerda = n;
    }

    @SuppressWarnings("unchecked")
    public <T extends No> T getDireita() {
        return (T) direita;
    }

    public void setDireita(No n) {
        this.direita = n;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public No getPai() {
        return this.pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public boolean isRed() {
        return this.isRed;
    }

    public void setIsRed(boolean b) {
        this.isRed = b;
    }

    @Override
    public String toString() {
        return isRed? this.chave + ":(R)" : this.chave + ":(B)";
    }

}
