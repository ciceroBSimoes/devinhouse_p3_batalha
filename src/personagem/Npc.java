package personagem;

public class Npc extends Personagem {

    public Npc(String nome, Double dano, Double defesa, Arma arma) {
        this.nome = nome;
        this.dano = dano;
        this.defesa = defesa;
        this.arma = arma;
    }
}
