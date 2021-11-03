package personagem;

public class Arma {

    private String nomeArma;
    private TipoArmaEnum tipo;
    private TipoClasse tipoClasseArma;
    private Double dano;

    public Arma(TipoArmaEnum tipo) {
        this.tipo = tipo;
        this.nomeArma = tipo.getNome();
        switch (tipo) {
            case ESPADA -> {
                this.dano = 30.0;
                this.tipoClasseArma = TipoClasse.GUERREIRO;
            }
            case MACHADO -> {
                this.dano = 32.0;
                this.tipoClasseArma = TipoClasse.GUERREIRO;
            }
            case CLAVA -> {
                this.dano = 29.0;
                this.tipoClasseArma = TipoClasse.GUERREIRO;
            }
            case MARTELO -> {
                this.dano = 28.0;
                this.tipoClasseArma = TipoClasse.GUERREIRO;
            }
            case ARCO -> {
                this.dano = 28.0;
                this.tipoClasseArma = TipoClasse.ATIRADOR;
            }
            case BESTA -> {
                this.dano = 30.0;
                this.tipoClasseArma = TipoClasse.ATIRADOR;
            }
            case CAJADO -> {
                this.dano = 32.0;
                this.tipoClasseArma = TipoClasse.MAGO;
            }
            case LIVRO -> {
                this.dano = 30.0;
                this.tipoClasseArma = TipoClasse.MAGO;
            }
            case MACHADODUPLO -> {
                this.dano = 40.0;
                this.tipoClasseArma = TipoClasse.NPC;
            }
        }
    }

    public TipoArmaEnum getTipo() {
        return tipo;
    }

    public TipoClasse getClasseArma() {
        return tipoClasseArma;
    }

    public Double getDano() {
        return dano;
    }

    public String getNomeArma() {
        return nomeArma;
    }
}
