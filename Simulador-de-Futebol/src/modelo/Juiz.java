package modelo;

public class Juiz extends Pessoa{
    private String cartaoAmarelo;
    private String cartaoVermelho;
    private int apitou = 0;

    //CONSTRUTOR
    public Juiz(String nomeJuiz){

    }

    //MÉTODOS
    public void falta(String f){
        if(f.equals("Grave")){
            System.out.println("Cartão Amarelo");
        } if (f.equals("Gravissíma")){
            System.out.println("Cartão Vermelho");
        }
        System.out.println("Cartão Vermelho");
    }

    public void apitou(int a) {
        if(apitou == 1){
            System.out.println("Começou o Jogo");
        } if (apitou == 2) {
            System.out.println("Acabou o primeiro tempo do Jogo");
        } if (apitou == 3) {
            System.out.println("Começou o segundo tempo do Jogo");
        } else {
            System.out.println("Começou o Jogo");
        }
    }
}
