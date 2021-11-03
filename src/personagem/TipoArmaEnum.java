package personagem;

public enum TipoArmaEnum {
    ESPADA("Espada"),
    MACHADO("Machado"),
    CLAVA("Clava"),
    MARTELO("Martelo"),
    ARCO("Arco e Flecha"),
    BESTA("Besta e Virote"),
    CAJADO("Cajado"),
    LIVRO("Livro"),
    MACHADODUPLO("Machado de Guerra");

    private final String nome;

    TipoArmaEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
