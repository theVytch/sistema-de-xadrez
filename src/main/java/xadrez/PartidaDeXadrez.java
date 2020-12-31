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

    private void lugarNovaPeca(char coluna, int linha, PecaDeXadrez peca){
        tabuleiro.lugarPeca (peca, new XadrezPosicao(coluna, linha).paraPosicao());
    }

    private void iniciarSetup(){
        lugarNovaPeca('b', 6, new Torre(tabuleiro, Cor.WHITE));
        lugarNovaPeca('e',8, new Rei(tabuleiro, Cor.BLACK));
    }
}
