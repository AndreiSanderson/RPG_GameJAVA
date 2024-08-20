public class Jogador extends Personagem{

    //integers para guardar o numero dos upgrades/skills de cada pacote.
    public int numAtkUpgrades, numDefUpgrades;

    //status adicionais ddo jogador
    int gold, gracaRest, poteCura; 

    //Arrays para guardar o nome das características
    public String[] atkUpgrades = {"Espada", "Corte Rapido", "Corte Infernal","Lamina da Tempestade","Dança das laminas"};
    public String[] defUpgrades = {"Escudo", "Escudo de aço", "Postura Inabalavel", "Barreira Elemental", "Campo de Forca"};

    public Jogador(String nome) {
        super(nome, 100, 0);
        //Adicionando o valor dos upgrades a 0;
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        
        //addicionar status adicionais
        this.gold = 6;
        this.gracaRest = 2;
        this.poteCura = 0;
        
        //permitindo a escolha de uma skill  quando criar o personagem
        ChooseTrait();

    }
    
    //metodo especifico do jogador
    @Override
    public int atacar() {
        int atk = (int) (Math.random()*(xp/2 + numAtkUpgrades * 3 + 7) + xp/10 + numAtkUpgrades*3 + numDefUpgrades + 2);
        if(atk <= 0){
            do{
                atk = (int) (Math.random()*(xp/2 + numAtkUpgrades * 3 + 7) + xp/10 + numAtkUpgrades*3 + numDefUpgrades + 2);
            }while(atk == 0);
        }
        return atk;
    }

    @Override
    public int defender() {
        int def = (int) (Math.random()*(xp/2 + numDefUpgrades * 3 + 5) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 2);
        return def;
    }

    public void ChooseTrait(){
        GameLogica.clearConsole();
        GameLogica.escreverCabecalho("Escolha uma característica:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        
        //Guardar as escolhas do usuário
        int input = GameLogica.readInt("-> ", 2);
        GameLogica.clearConsole();
        
        if(input == 1){
            GameLogica.escreverCabecalho("Sua escolha foi " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            GameLogica.escreverCabecalho("Sua escolha foi " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;         
        }
        GameLogica.qlqrCoisaCont();
    }
}





