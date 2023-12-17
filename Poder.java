class Poder {
    private String nome;
    private int custoMana;
    private int dano;

    public Poder(String nome, int custoMana, int dano) {
        this.nome = nome;
        this.custoMana = custoMana;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public int getDano() {
        return dano;
    }

    public String usarPoder(Personagem atacante, Personagem oponente) {
        if (atacante.temManaSuficiente(custoMana)) {
            System.out.println(atacante.getNome() + " usa " + nome + "!");
            oponente.sofrerDano(dano);
            atacante.sofrerDano(custoMana); // Custo de mana é descontado do atacante
            System.out.println("Dano causado: " + dano);
            return nome;
        } else {
            System.out.println("Mana suficiente para usar " + nome + ".");
            return null;
        }
    }
}
