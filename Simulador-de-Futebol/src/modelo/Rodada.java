package modelo;

public class Rodada {
    private Time timeCasa;
    private Time timeVisitante;
    private int golCasa;
    private int golVisitante;

    //COSTRUTOR
    public Rodada(Time timeCasa, Time timeVisitante){
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(int golVisitante) {
        this.golVisitante = golVisitante;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }
}
