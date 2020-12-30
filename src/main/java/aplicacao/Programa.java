package aplicacao;

import mesaJogo.Posicao;
import mesaJogo.Tabuleiro;
import xadrez.PartidaDeXadrez;

public class Programa {

    public static void main(String[] args) {

        PartidaDeXadrez partidaXadrez = new PartidaDeXadrez();
        IU.mostraTabuleiro(partidaXadrez.getPecas());
    }
}
