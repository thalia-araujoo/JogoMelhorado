
// Classe base para Arma
class Arma {
    private String nome;
    private int forca;
    private int precisao;
    private String efeitoEspecial;

    public Arma(String nome, int forca, int precisao, String efeitoEspecial) {
        this.nome = nome;
        this.forca = forca;
        this.precisao = precisao;
        this.efeitoEspecial = efeitoEspecial;
    }

    public String getNome() {
        return nome;
    }

    public int getForca() {
        return forca;
    }

    public int getPrecisao() {
        return precisao;
    }

    public String getEfeitoEspecial() {
        return efeitoEspecial;
    }
}