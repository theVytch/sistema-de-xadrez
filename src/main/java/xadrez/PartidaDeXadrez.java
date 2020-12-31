package xadrez;

import mesaJogo.Posicao;
import mesaJogo.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

    private Tabuleiro tabuleiro;


    public PartidaDeXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
        iniciarSetup();
    }

    public PecaDeXadrez[][] getPecas(){
        PecaDeXadrez[][] matriz = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for(int i=0; i < tabuleiro.getLinhas(); i++){
            for(int j=0; j < tabuleiro.getColunas(); j++){
                matriz[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
            }
        }
        return matriz;
    }

    private void iniciarSetup(){
        tabuleiro.lugarPeca(new Torre(tabuleiro, Cor.WHITE), new Posicao(2, 1));
        tabuleiro.lugarPeca(new Rei(tabuleiro, Cor.BLACK), new Posicao(0, 4));
    }
}
