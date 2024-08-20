public class Inimigos extends Personagem{

    //variavel para guardar o xp do jogador
    int jogadorxp;

    public Inimigos(String nome, int jogadorxp) {
        super(nome, (int) (Math.random()*jogadorxp + jogadorxp/2 + 10), (int) (Math.random()*(jogadorxp/2 + 2) + 2));
        //alterando o valor da váriavel
        this.jogadorxp = jogadorxp;
    }

    //calculo especifico do atk e def

    @Override
    public int atacar() {
        int atk =  (int) (Math.random()*(jogadorxp/4 + 7) + xp/4 + 3);
        if(atk <= 0){
            do{
                atk =  (int) (Math.random()*(jogadorxp/4 + 7) + xp/4 + 3);
            }while(atk == 0);
        }
        return atk;
    }

    @Override
    public int defender() {
        int def = (int) (Math.random()*(jogadorxp/4 + 4) +  xp/4 + 3);
        return def;
    }
    
}
