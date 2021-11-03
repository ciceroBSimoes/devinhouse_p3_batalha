package personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classe {

    private String nomeClasse, id;
    private TipoClasse tipoClasse;
    private Double dano, defesa;
    private List<Arma> armas = new ArrayList<>();

    public Classe(TipoClasse classe) {

        this.tipoClasse = classe;
        this.nomeClasse = classe.getNome();
        switch (classe) {
            case GUERREIRO -> {
                this.id = "1";
                this.defesa = 27.0;
                this.dano = 25.0;
            }
            case ATIRADOR -> {
                this.id = "2";
                this.defesa = 23.0;
                this.dano = 25.0;
            }
            case MAGO -> {
                this.id = "3";
                this.defesa = 23.0;
                this.dano = 28.0;
            }
        }
    }

    public List<Arma> getArmas() {

        for (TipoArmaEnum tipo : TipoArmaEnum.values()) {
            armas.add(new Arma(tipo));
        }
        return armas.stream().filter((arma) -> arma.getClasseArma() == this.tipoClasse).collect(Collectors.toList());
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public String getId() {
        return id;
    }

    public Double getDano() {
        return dano;
    }

    public Double getDefesa() {
        return defesa;
    }
}
