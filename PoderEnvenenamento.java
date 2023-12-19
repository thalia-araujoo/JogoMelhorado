
public class PoderEnvenenamento extends Poder {
    public PoderEnvenenamento() {
        super("Envenenamento", 35, 40);
    }
    //Metodo sobescrito, da classe base, sendo ultilizado a mesma assinatura, porém com atributos especificos
    @Override
    public String usarPoder(Personagem atacante, Personagem oponente) {
        if (atacante.temManaSuficiente(getCustoMana())) {
            System.out.println(atacante.getNome() + " usa " + getNome() + "!");
            oponente.sofrerDano(getDano());
            atacante.gastarMana(getCustoMana());
            System.out.println("Dano causado: " + getDano());
            System.out.println("O oponente está envenenado!");
            return getNome();
        } else {
            System.out.println("Mana insuficiente para usar " + getNome() + ".");
            return null;
        }
    }
}