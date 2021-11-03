package personagem;

public class Personagem {

    protected String nome;
    protected Double defesa, dano, vida = 100.0;
    protected Classe classeDeCombate;
    protected Arma arma;
    protected GeneroEnum generoEnum;

    public Classe getClasseDeCombate() {
        return classeDeCombate;
    }

    public void setClasseDeCombate(Classe classeDeCombate) {
        this.classeDeCombate = classeDeCombate;
        this.dano = this.classeDeCombate.getDano();
        this.defesa = this.classeDeCombate.getDefesa();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroEnum getGenero() {
        return generoEnum;
    }

    public void setGenero(String opcao) {
        if (opcao.equals("1")) {
            this.generoEnum = GeneroEnum.MASCULINO;
        } else {
            this.generoEnum = GeneroEnum.FEMININO;
        }
    }

    public Double getVida() {
        return vida;
    }

    public void setVida(Double vida) {
        this.vida = vida;
    }

    public Double getDefesa() {
        return defesa;
    }

    public Double getDano() {
        return dano;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setDefesa(Double defesa) {
        this.defesa = defesa;
    }
}
