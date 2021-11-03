package personagem;

public enum TipoClasse {
    GUERREIRO("Guerreiro"),
    ATIRADOR("Atirador"),
    MAGO("Mago"),
    NPC("Npc");

    private final String nome;

    TipoClasse(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
