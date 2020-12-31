package aplicacao;


import xadrez.PecaDeXadrez;

//inteface de usuario
public class IU {

    public static void mostraTabuleiro(PecaDeXadrez[][] pecas) {
        for(int i = 0; i < pecas.length; i++){
            System.out.print(8 - i + " ") ;
            for (int j = 0; j <pecas.length; j++ ){
                mostraPeca(pecas[i][j]);
            }
            System.out.println();
        }
        System.out.print("  a b c d e f g h");
    }

    private static void mostraPeca(PecaDeXadrez peca) {
        if (peca == null) {
            System.out.print("-");
        } else {
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
