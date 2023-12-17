// Classe derivada para Guerreiro (exemplo de herança)
class Zoro extends Personagem {
    public Zoro(String nome, int vida, Arma arma, Poder poder) {
        super(nome, vida, arma, poder);
    }
    @Override
    public void usarPoderZoro(Personagem oponente) {
        
        System.out.println("Zoro usa o poder de Envenamento!");
        oponente.sofrerDano(this.getPoder().getDano());
    }
    
}