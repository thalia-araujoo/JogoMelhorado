class Lufy extends Personagem {
    public Lufy(String nome, int vida, Arma arma, Poder poder) {
        super(nome, vida, arma, poder);
    }
    @Override
    public void usarPoderLufy(Personagem oponente) {
        // Lógica específica para o poder de Lufy
        System.out.println("Lufy usa o poder de Endurecimento!");
        oponente.sofrerDano(this.getPoder().getDano());
    }
}
