package modelo;

public class Jogador extends Pessoa {
    //ATRIBUTOS
    private int numeroCamisa;
    private String posicaoCampo;
    private int cartoes;
    private int gol = 0;

    private int numeroFaltas;



    //CONSTRUTOR
    public Jogador(String nome, int numeroCamisa, String tipoJogador, String posicaoCampo) {
        this.nome = nome;
        this.numeroCamisa = numeroCamisa;
        this.posicaoCampo = posicaoCampo;
        this.numeroFaltas = 0; //já fica iniciado no construtor para todos os jogadores
    }



    //MÉTODOS GETTERS E SETTERs
    //número
    public void setNumeroCamisa(int numeroCamisa) {
        if (numeroCamisa <= 0) {
            System.out.println("Não pode valor menor ou igual a 0");
        }
        this.numeroCamisa = numeroCamisa;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    //posição
    public void setPosicaoCampo(String posicaoCampo) {
        this.posicaoCampo = posicaoCampo;
    }

    public String getPosicaoCampo() {
        return posicaoCampo;
    }

    //cartões
    public void setCartoes(int cartoes) {
        this.cartoes = cartoes;
    }

    public int getCartoes() {
        return cartoes;
    }

    public void faltasCometida(int numeroFaltas, String tipoFalta) {
        boolean grave = tipoFalta.equals("Grave");
        if (this.numeroFaltas <= 1 && tipoFalta.equals("Grave")) {
            System.out.println("O jogador " + getNome() + " cometeu falta! Recebe cartão Amarelo do juiz.");
        } else if (this.numeroFaltas <= 1 && tipoFalta.equals("Leve")) {
            System.out.println("O jogador " + getNome() + " cometeu falta!");
        } else if (this.numeroFaltas <= 1 && tipoFalta.equals("Gravissima")) {
            System.out.println("O jogador " + getNome() + " cometeu falta! Recebe cartão Vermelho do juiz e é expulso.");
        } else {
            this.numeroFaltas++;
        }
    }

    @Override
    public String toString() {
        return nome + " camisa " + numeroCamisa;
    }
}