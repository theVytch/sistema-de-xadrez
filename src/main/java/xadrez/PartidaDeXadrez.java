package xadrez;

import mesaJogo.Peca;
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

    public PecaDeXadrez performaceMovimentoXadrez(XadrezPosicao origemPosicao, XadrezPosicao alvoPosicao){
        Posicao origem = origemPosicao.paraPosicao();
        Posicao alvo = alvoPosicao.paraPosicao();
        validaPosicao(origem);
        Peca capturaPeca = fazMovimento(origem, alvo);
        return (PecaDeXadrez) capturaPeca;
    }

    private Peca fazMovimento(Posicao origem,Posicao alvo){
        Peca p = tabuleiro.removePeca(origem);
        Peca pecaCapturada = tabuleiro.removePeca(alvo);
        tabuleiro.lugarPeca(p, alvo);
        return pecaCapturada;
    }

    private void validaPosicao(Posicao posicao){
        if (!tabuleiro.temUmaPeca(posicao)){
            throw new XadrezException("nao existe peca na posicao de origem");
        }
    }

    private void lugarNovaPeca(char coluna, int linha, PecaDeXadrez peca){
        tabuleiro.lugarPeca (peca, new XadrezPosicao(coluna, linha).paraPosicao());
    }

    private void iniciarSetup(){

        lugarNovaPeca('c', 1, new Torre(tabuleiro, Cor.WHITE));
        lugarNovaPeca('c', 2, new Torre(tabuleiro, Cor.WHITE));
        lugarNovaPeca('d', 2, new Torre(tabuleiro, Cor.WHITE));
        lugarNovaPeca('e', 2, new Torre(tabuleiro, Cor.WHITE));
        lugarNovaPeca('e', 1, new Torre(tabuleiro, Cor.WHITE));
        lugarNovaPeca('d', 1, new Rei(tabuleiro, Cor.WHITE));

        lugarNovaPeca('c', 7, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('c', 8, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('d', 7, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('e', 7, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('e', 8, new Torre(tabuleiro, Cor.BLACK));
        lugarNovaPeca('d', 8, new Rei(tabuleiro, Cor.BLACK));
    }
}
