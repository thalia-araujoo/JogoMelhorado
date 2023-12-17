// Classe derivada para Kisame
class Kisame extends Personagem {
    public Kisame(String nome, int vida, Arma arma, Poder poder) {
        super(nome, vida, arma, poder);
    }
    @Override
    public void usarPoderKisame(Personagem oponente) {
        // Lógica específica para o poder de Kisame
        System.out.println("Kisame usa o poder de congelamento!");
        oponente.sofrerDano(this.getPoder().getDano());
    }
}