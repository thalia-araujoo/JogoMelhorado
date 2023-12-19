
// Classe base para Personagem
class Personagem {
    //Encapsulamento
    private String nome;
    private int vida;
    private Arma arma;
    private Poder poder;
    private int mana;

    //construtor
    public Personagem(String nome, int vida, Arma arma, Poder poder) {
        this.nome = nome;
        this.vida = vida;
        this.arma = arma;
        this.poder = poder;
        this.mana = 100; // Valor inicial da mana
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public Arma getArma() {
        return arma;
    }

    public Poder getPoder() {
        return poder;
    }
    //metodo para receber dano
    public void sofrerDano(int dano) {
        this.vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
    }
    //ele vai retornar true ou false para se tem mana suficiente
    public boolean temManaSuficiente(int custoMana) {
        return this.mana >= custoMana;
    }
    //ele diminui a mana atual
    public void gastarMana(int custoMana) {
        this.mana -= custoMana;
    }
    
    /*Verifica se o personagem possui um poder especial.
    Se sim, utiliza o poder chamando o método usarPoder da instância de Poder. */
    public void usarPoder(Personagem oponente) {
        if (this.getPoder() != null) {
            String nomePoder = this.getPoder().usarPoder(this, oponente);
            if (nomePoder != null) {
                System.out.println(this.getNome() + " usou o poder: " + nomePoder);
            }
        } else {
            System.out.println("Este personagem não possui um poder associado.");
        }
    }
}
