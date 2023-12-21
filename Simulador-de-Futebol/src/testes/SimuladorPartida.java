package testes;

import modelo.Jogador;
import modelo.Rodada;
import modelo.Time;
import modelo.Juiz;

import java.util.ArrayList;
import java.util.List;

public class SimuladorPartida {
    public static void main(String[] args) {
        //LISTA = Titulares e Reservas do Internacional
        List<Jogador> interTitulares = new ArrayList<>();
        interTitulares.add(new Jogador("John", 1, "Titular", "Goleiro"));
        interTitulares.add(new Jogador("Bustos", 2, "Titular","Lateral Esquerdo"));
        interTitulares.add(new Jogador("Renê", 3, "Titular","Lateral Direito" ));
        interTitulares.add(new Jogador("Igor Gomes", 4, "Titular","Zagueiro"));
        interTitulares.add(new Jogador("Mercado", 5, "Titular","Zagueiro"));
        interTitulares.add(new Jogador("Nico Hernández", 6, "Titular","Zagueiro"));
        interTitulares.add(new Jogador("Enner Valencia", 7, "Titular","Atacante"));
        interTitulares.add(new Jogador("Jean Dias", 8, "Titular","Atacante"));
        interTitulares.add(new Jogador("Gabriel Barros", 9, "Titular","Centroavante"));
        interTitulares.add(new Jogador("Matheus", 10, "Titular","Defesa"));
        interTitulares.add(new Jogador("Rômulo", 11, "Titular","Defesa"));


        List<Jogador> interReservas = new ArrayList<>();
        interReservas.add(new Jogador("Felipe", 12,"Reserva","Goleiro"));
        interReservas.add(new Jogador("Caleb", 13, "Reserva","Lateral Esquerdo"));
        interReservas.add(new Jogador("Fernando", 14,"Reserva","Lateral Direito"));
        interReservas.add(new Jogador("Lucas", 15, "Reserva","Zagueiro"));
        interReservas.add(new Jogador("Noah", 16, "Reserva","Zagueiro"));
        interReservas.add(new Jogador("Guto", 17, "Reserva","Atacante"));
        interReservas.add(new Jogador("Paulo", 18, "Reserva","Defesa"));

        //LISTA = Titulares e Reservas do Gremio
        List<Jogador> gremioTitulares = new ArrayList<>();
        gremioTitulares.add(new Jogador("Caíque Santos", 1, "Titular", "Goleiro"));
        gremioTitulares.add(new Jogador("João Pedro", 2, "Titular","Lateral Esquerdo"));
        gremioTitulares.add(new Jogador("Fabio", 3, "Titular","Lateral Direito"));
        gremioTitulares.add(new Jogador("Bruno Alves", 4, "Titular","Zagueiro"));
        gremioTitulares.add(new Jogador("Rodrigo Elli", 5, "Titular","Zagueiro"));
        gremioTitulares.add(new Jogador("Natã", 6, "Titular","Zagueiro"));
        gremioTitulares.add(new Jogador("Luan", 7, "Titular","Atacante"));
        gremioTitulares.add(new Jogador("André Henrrique", 8, "Titular","Atacante"));
        gremioTitulares.add(new Jogador("Pepê", 9, "Titular","Centroavante"));
        gremioTitulares.add(new Jogador("Mila", 10, "Titular","Defesa"));
        gremioTitulares.add(new Jogador("Ronald", 11, "Titular","Defesa"));

        List<Jogador> gremioReservas = new ArrayList<>();
        gremioReservas.add(new Jogador("Fabio", 12,"Reserva","Goleiro"));
        gremioReservas.add(new Jogador("Junior", 13, "Reserva","Lateral Esquerdo"));
        gremioReservas.add(new Jogador("Henrrico", 14,"Reserva","Lateral Direito"));
        gremioReservas.add(new Jogador("Pablo", 15, "Reserva","Zagueiro"));
        gremioReservas.add(new Jogador("Pedro", 16, "Reserva","Zagueiro"));
        gremioReservas.add(new Jogador("Vitor", 17, "Reserva","Atacante"));
        gremioReservas.add(new Jogador("Samuel", 18, "Reserva","Defesa"));


        Time internacional = new Time("Eduardo Coudet", "Interacional", interTitulares);
        Time gremio = new Time("Renato Gaucho", "Gremio", gremioTitulares);

        System.out.println("Times: " + internacional.getNomeTime() + " x " + gremio.getNomeTime());
        System.out.println("Técnicos: " + internacional.getNomeTecnico() + " e " + gremio.getNomeTecnico());

        Juiz juiz = new Juiz("João");
        Rodada rodada = new Rodada(internacional, gremio);
        juiz.apitou(1);

        internacional.fazerGol(rodada, 8);

        System.out.println("-----------TESTE método fazerGol----------");
        internacional.fazerGol(rodada, 70);
        System.out.println("------------------------------------------");

        System.out.println("PLACAR: " + rodada.getGolVisitante() + " X " + rodada.getGolCasa());

        internacional.getJogador(5).faltasCometida(1, "Grave");
        internacional.getJogador(5).faltasCometida(1, "Gravissima");
        //internacional.getJogador(5).getCartoes(); // ---- NÃO ESTÁ FUNCIONANDO
        internacional.getJogador(5).toString();
        //System.out.println(internacional.getJogadores().size());
        internacional.remove(internacional.getJogador(5));

        System.out.println("-----------TESTE total de jogadores----------");
        System.out.println("Agora o time Internacional tem " + internacional.getJogadores().size() + " jogadores"); // vemos o tamanho da lista após a remoção
        System.out.println("---------------------------------------------");

        gremio.trocaJogador(gremioTitulares, gremioReservas, "André Henrrique", "Vitor");

        /*System.out.println("-----------TESTE posição em campo----------");
        gremio.getJogador(17).getPosicaoCampo();
        System.out.println("----------------------------------------------");*/

        System.out.println("-----------TESTE método trocaJogador----------");
        gremio.trocaJogador(gremioTitulares, gremioReservas, "André Henrrique", "Samuel"); //posições diferentes
        gremio.trocaJogador(gremioTitulares, gremioReservas, "André Henrrique","Jabel"); //não contém este jogador
        System.out.println("----------------------------------------------");
    }
}
