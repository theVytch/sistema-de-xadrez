package aplicacao;

import mesaJogo.Posicao;
import mesaJogo.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.XadrezPosicao;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);


        PartidaDeXadrez partidaXadrez = new PartidaDeXadrez();

        while (true) {

            IU.mostraTabuleiro(partidaXadrez.getPecas());
            System.out.print();
            System.out.print("Origem: ");
            XadrezPosicao origem = IU.lerPosicaoXadrez(ler);

            System.out.print();
            System.out.print("Alvo: ");
            XadrezPosicao alvo = IU.lerPosicaoXadrez(ler);
            PecaDeXadrez capture = partidaXadrez.performaceMovimentoXadrez(origem, alvo);
        }

    }
}
