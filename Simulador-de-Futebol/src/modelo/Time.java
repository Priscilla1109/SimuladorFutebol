package modelo;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nomeTecnico;
    private String nomeTime;
    private int gols;
    private List<Jogador> jogadores;

    //CONSTRUTOR
    public Time(String nomeTecnico, String nomeTime, List<Jogador> jogadores) {
        this.nomeTecnico = nomeTecnico;
        this.nomeTime = nomeTime;
        this.jogadores = jogadores;
    }

    //MÉTODOS

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public void setNomeTecnico(String nomeTecnico) {
        this.nomeTecnico = nomeTecnico;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public void fazerGol(Rodada rodada, int numeroCamisa){
        try {
            if (this.nomeTime.equals(rodada.getTimeCasa().getNomeTime()) && numeroCamisa < 18) { //----REVER CONDIÇÃO SOMENTE PARA JOGADORES TITULARES
                rodada.setGolCasa(rodada.getGolCasa() + 1);
            } else if (numeroCamisa < 18){
                rodada.setGolVisitante(rodada.getGolVisitante() + 1);
            }
            System.out.println("Gool do " + this.nomeTime + " jogador: " + this.exibirNomeJogador(this.getJogador(numeroCamisa)));
        } catch (Exception e){
            System.out.println("Não foi possível fazer gol");
        }
    }

    private String exibirNomeJogador (Jogador jogador){
        try {
            return jogador.getNome();
        } catch (Exception e) {
            throw e;
        }
        /*return "Jogador Insistente";*/
    }

    /**
     * esse método localiza pelo número da camisa, não usa o nome porque pode ter nomes repetidos.
     * @param numeroCamisa
     * @return Jogador
     */
    public Jogador getJogador(int numeroCamisa) {
        for(Jogador j:this.jogadores) {
            if (j.getNumeroCamisa() == numeroCamisa){
                return j;
            }
        }
        return null;
    }
    public List<Jogador> remove(Jogador jogador) {
        List<Jogador> aux = new ArrayList<>();
        for (Jogador j:this.jogadores) {
            if (jogador.getNumeroCamisa() != j.getNumeroCamisa()) {
                aux.add(j);
            }
        }
        this.jogadores = aux;
        return this.jogadores;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void trocaJogador(List<Jogador> timeTitular, List<Jogador> timeReserva, String nomeTitular, String nomeReserva){
        Jogador jogadorTitular = encontraJogador(timeTitular, nomeTitular);
        Jogador jogadorReserva = encontraJogador(timeReserva, nomeReserva);

        if (jogadorTitular != null && timeReserva != null && jogadorTitular.getPosicaoCampo().equals(jogadorReserva.getPosicaoCampo())) {
            timeTitular.remove(jogadorTitular);
            timeReserva.remove(jogadorReserva);

            timeTitular.add(jogadorReserva);
            //jogadorTitular.setPosicaoCampo("Rerserva");

            timeReserva.add(jogadorTitular);
            //jogadorReserva.setPosicaoCampo("Titular");

            System.out.println("Foi realizada a substituição entre o jogador " + jogadorTitular + " pelo jogador " + jogadorReserva);
        } else {
            System.out.println("Não foi possível realizar a substituição entre os jogadores");
        }
    }

    private Jogador encontraJogador(List<Jogador> time, String nome) {
        for (Jogador jogador : time) {
            if (jogador.getNome().equals(nome)) {
                return jogador;
            }
        }
        return null;
    }
}
