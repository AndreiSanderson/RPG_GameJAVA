public class Boss extends Personagem {
    
    
    public Boss(String nome, int maxHp, int xp) {
        super(nome, maxHp, xp);
        this.nome = nome;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    public int jogadorxp;




    // Cálculo específico do atk e def para o Boss

    @Override
    public int atacar() {
        int atk =  (int) (Math.random() * (xp/3 + 15) + xp/3 + 5);
        if(atk <= 0){
            do{
                atk =  (int) (Math.random() * (xp/3 + 15) + xp/3 + 5);
            }while(atk == 0);
        }
        return atk;
    }

    @Override
    public int defender() {
        int def = (int) (int) (Math.random() * (xp/3 + 7) + xp/3 + 5);
    return def;
    }
    
    // Método exclusivo para Boss, como um ataque especial
    public int ataqueEspecial() {
        int atkEsp =  (int) (Math.random() * (xp/2 + 23) + xp/2 + 10);
        if(atkEsp <= 0){
            do{
                atkEsp =  (int) (Math.random() * (xp/2 + 23) + xp/2 + 10);
            }while(atkEsp < 5);
        }
        return atkEsp;
    }
    
}
