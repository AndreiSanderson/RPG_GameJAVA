public abstract class Personagem {
    //Atributos do personagem
    public String nome;
    public int maxHp, hp, xp;

    //constructor para o personagem
    public Personagem(String nome, int maxHp, int xp){
        this.nome = nome;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp  = maxHp;
    }

    public Personagem(String nome2, int maxHp2) {
        //TODO Auto-generated constructor stub
    }

    //metodos do personagem 
    public abstract int atacar();
    public abstract int defender();

}
