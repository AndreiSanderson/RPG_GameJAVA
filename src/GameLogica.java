import java.util.Scanner;

public class GameLogica {
    static Scanner scanner = new Scanner(System.in);

    static Jogador jogador;

    public static boolean isRunning;

    //encontrom aleátorios
    public static String[] encontros = {"Loja", "Batalha", "Batalha", "Batalha", "Batalha", "Batalha", "Graca", "Graca", "Graca", "Graca", "Graca", "Batalha"};

    //Nome dos inimigos
    public static String[] inimigo = {"Gigante de Fogo","Cavaleiro da Morte","Soldado do Radahn","Soldado do Godryck","Black Knight", "Morcego Gigante", "Soldado Exilado", "Guerreiro Golem", "Cavaleiros de Leyendel", "CRUCIBLE KNIGHT", "Assassino das Facas Negras", "Ancient Dragon"};

    //Elementos da história
    public static int place = 0, act = 0;
    public static String[] places = {"Limgrave", "Caelid", "Leyendel, Capital da Tervore", "Coracao da Arvore"};

    //método para pegar o INPUT do usuário, adicionado no console. 
    public static int readInt(String prompt, int escolhasUsuario){
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch(Exception e){
                input = -1;
                System.out.println("Por favor! Digite um numero valido!");
            }

        }while(input < 1 || input > escolhasUsuario);
        return input;
    }

    //método para simular limpando o console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }
    
    //metodo para escrever uma separação com tamanho n
    public static void separarEscrita(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-");
        }System.out.println();
    }

    //metodo para escrever um cabeçalho
    public static void escreverCabecalho(String titulo){
        separarEscrita(30);
        System.out.println(titulo);
        separarEscrita(30);
    }

    //metodo para parar o jogo até o usuário adicionar informação
    public static void qlqrCoisaCont(){
        System.out.println("\nToque em qualquer tecla para continuar...");
        scanner.next();
    }

    //metoddo para começar o jogo
    public static void comecarJogo(){
        boolean nameSet = false;
        String nome;
        //tela inicial
        clearConsole();
        separarEscrita(40);
        separarEscrita(40);
        System.out.println("Lost Time: Era Das trevas");
        System.out.println("RPG de texto criado por Andrei Sanderson, em formacao em JAVA");
        separarEscrita(40);
        separarEscrita(40);
        qlqrCoisaCont();

        //salvando o nome do jogador
        do{
            clearConsole();
            escreverCabecalho("Informe seu nome para iniciar");
            nome = scanner.next();
            //perguntando se o nome do jogador está correto
            clearConsole();
            escreverCabecalho("Seu nome é " + nome + ".\nDeseja prosseguir com este nome?");
            System.out.println("(1) Sim!");
            System.out.println("(2) Nao, desejo trocar meu nome");
            int input = readInt("-> " , 2);
            if(input == 1){
                nameSet = true;
            }
        }while(!nameSet);
    
        //adicionando a intrrodução da história.
        Historia.introducao();

        //cria um novo objeto com o nome do jogador
        jogador  = new Jogador(nome);

        //adicinoando o ato1
        Historia.Ato1();
        act = 1;

        //configurando a variavel boolean "true", para o gameLoop poder continuar
        isRunning = true;

        //começar o loop do jogo
        gameLoop();
    }

    //Metodo que muda o valor do jogo baseado no xp jo jogador
    public static void checkAto(){
            if(jogador.xp >= 10 && act ==1){
            //alterando o ato e os lugares
            act = 2;
            place = 1;
            //historia
            sentarGraca();
            boss1();
            Historia.Ato1Fim();
            //jogador upa
            jogador.ChooseTrait();
            //historia ++
            
            inimigo[0] = "Soldado Exilado";
            inimigo[1] = "Soldado Exilado";
            inimigo[2] = "Morcego Gigante";
            inimigo[3] = "Morcego Gigante";
            inimigo[4] = "Black Night";
            inimigo[5] = "Guerreiro Golem";
            inimigo[6] = "Guerreiro Golem";
            inimigo[7] = "Soldado do Godrick";

            encontros[0] = "Batalha";
            encontros[1] = "Batalha";
            encontros[2] = "Graca";
            encontros[3] = "Batalha";
            encontros[4] = "Batalha";
            encontros[5] = "Batalha";
            encontros[6] = "Batalha";
            encontros[7] = "Batalha";
            encontros[8] = "Batalha";
            encontros[9] = "Loja";
            //Curar o jogador
            jogador.hp = jogador.maxHp;
        }else if(jogador.xp >= 50 && act ==2){
            act = 3;
            place = 2;
            Historia.Ato2();
            boss2();
            Historia.Ato2Fim();
            jogador.ChooseTrait();
            inimigo[0] = "Cavaleiro da Morte";
            inimigo[1] = "Cavaleiro da Morte";
            inimigo[2] = "Soldado Radahn";
            inimigo[3] = "Soldado Radahn";
            inimigo[4] = "Black Night";
            inimigo[5] = "Black Night";
            inimigo[6] = "CRUCIBLE KNIGHT";
            inimigo[7] = "Assassino das Facas Negras";

            encontros[0] = "Batalha";
            encontros[1] = "Batalha";
            encontros[2] = "Graca";
            encontros[3] = "Batalha";
            encontros[4] = "Batalha";
            encontros[5] = "Batalha";
            encontros[6] = "Batalha";
            encontros[7] = "Batalha";
            encontros[8] = "Batalha";
            encontros[9] = "Loja";

        }else if(jogador.xp >= 75 && act ==3){
            act = 4;
            place = 3;
            Historia.Ato3();
            boss3();
            Historia.Ato3Fim();
            jogador.ChooseTrait();
            Historia.fim();
            inimigo[0] = "CRUCIBLE KNIGHT";
            inimigo[1] = "Ancient Dragon";
            inimigo[2] = "Gigante de Fogo";
            inimigo[3] = "Cavaleiros de Leyendel";
            inimigo[4] = "Assassino das Facas Negras";
            inimigo[5] = "Cavaleiros de Leyendel";
            inimigo[6] = "CRUCIBLE KNIGHT";

            encontros[0] = "Batalha";
            encontros[1] = "Batalha";
            encontros[2] = "Graca";
            encontros[3] = "Batalha";
            encontros[4] = "Batalha";
            encontros[5] = "Batalha";
            encontros[6] = "Batalha";
            encontros[7] = "Batalha";
            encontros[8] = "Batalha";
            encontros[9] = "Loja";
            //Curar o jogador
            jogador.hp = jogador.maxHp;

        }else if(jogador.xp >= 75 && act == 4){
            place = 4;
            Historia.Final();
            finalbattle();
            Historia.Final2();
        }
    }

    //metodo para calcular um encontro aleatório.
    public static void randomEnc(){
        int encontro =  (int) (Math.random()* encontros.length);

        //calcular o respectivo metodo
        if(encontros[encontro].equals("Batalha")){
            randombattle();
        }else if(encontros[encontro].equals("Graca")){
            sentarGraca();
        }else{
            shop();
        }
    }

    //metodo para continuar a jornada
    public static void continuarJornada(){
        checkAto();
        if(act !=4 ){
            randomEnc();
        }
    }

    //metodo para mostrar as informações do jogador
    public static void infoPersonagem(){
        clearConsole();
        escreverCabecalho("STATUS do Personagem");
        System.out.println(jogador.nome + "\tHP: " + jogador.hp + "/" + jogador.maxHp);
        separarEscrita(20);
        //Mostrar o XP e o Ouro        
        System.out.println("XP: " + jogador.xp + "\tOuro: " + jogador.gold);
        separarEscrita(20);
        ///Numero de potes de cura
        System.out.println("Número de pocoes de cura: "+ jogador.poteCura);
        separarEscrita(20);
        //mostrar as características escolhidas
        if(jogador.numAtkUpgrades > 0){
            System.out.println("Caracteristicas Ofensivas: " + jogador.atkUpgrades[jogador.numAtkUpgrades]);
            separarEscrita(20);
        }
        if(jogador.numDefUpgrades > 0){
            System.out.println("Caracteristicas Defensivas: " + jogador.defUpgrades[jogador.numDefUpgrades]);
            separarEscrita(20);
        }
        qlqrCoisaCont();
    } 

    //mercado // encontrando um mercador viajante
    public static void shop(){
        clearConsole();
        escreverCabecalho("Voce encontrou uma estranho misterioso\nEle te oferece uma coisa:");
        int preco = (int) (Math.random() * (10 + jogador.poteCura*3) + 10 + jogador.poteCura);
        System.out.println(" - Pocao de cura: " + preco + "Ouros.");
        separarEscrita(20);
        //verificar se o jogador deseja comprar
        System.out.println("Voce deseja comprar?\n(1) SIM!\n(2) Nao, obrigado!");
        int input = readInt("-> ", 2);
        ///verificação se o usuário quer comprar
        if(input == 1){
            clearConsole();
            //verificar se o usuário tem ouro suficiente
            if(jogador.gold >= preco){
                escreverCabecalho("Voce comprou uma pocao misteriosa por " + preco + "ouros.");
                jogador.poteCura++;
                jogador.gold -= preco;
                if(jogador.gold > 30){
                    int danoMercador = (int)(Math.random()* 14);
                    int ouroMercador =  (int)(Math.random()* 20);
                    jogador.gold = jogador.gold - ouroMercador;
                    jogador.hp = jogador.hp - danoMercador;
                    escreverCabecalho("Ao pagar o estranho, ele viu que voce tinha muitas moedas de ouro e decidiu te roubar\nVoce tomou " + danoMercador +"de dano!\n e perdeu " + ouroMercador + " de ouro!" );
                    if(jogador.hp <= 0){
                        morte();
                    }
                }else{
                    escreverCabecalho("Voce nao tem ouro sificiente para comprar isso...");
                    
                }qlqrCoisaCont();
            }
        }
    } 

    //Descançar na graça
    public static void sentarGraca(){
        clearConsole();
        if(jogador.gracaRest >= 1){
            escreverCabecalho("Voce deseja descacar na Graca? ("+ jogador.gracaRest + ") Graca(s) restantes.");
            System.out.println("(1) Sim\n(2) Nao, agora nao...");
            int input = readInt("-> ", 2);
            if (input == 1) {
                //jogador descança
                clearConsole();
                if(jogador.hp < jogador.maxHp){
                    jogador.hp = jogador.maxHp;
                    System.out.println("Voce descancou e recuperou toda sua vida!");
                    jogador.gracaRest--;
                }
            }else{
                System.out.println("Voce esta com a vida maxima, nao precisa descancar agora!");
            }qlqrCoisaCont();
        }
    }

    //metodo de batalha alatória
    public static void randombattle(){
        clearConsole();
        escreverCabecalho("Voce encontrou um inimigo, Boa sorte na batalha!");
        qlqrCoisaCont();
        //creando um encontro com inimigo
        battle(new Inimigos(inimigo[(int)(Math.random()*inimigo.length)], act));

    }

    //batalha principal
    public static void battle(Inimigos inimigos) {
        //loop da batalha
        while(true){
            clearConsole();
            escreverCabecalho(inimigos.nome + "\nHP: " + inimigos.hp + "/" + inimigos.maxHp);
            escreverCabecalho(jogador.nome + "\nHP: " + jogador.hp + "/" + jogador.maxHp);
            System.out.println("Escolha oque fazer:");
            separarEscrita(20);
            System.out.println("(1) Lutar\n(2) curar\n (3) Fugir");
            int input = readInt("-> ", 3);
            //if para as escolhas do usuário
            if(input == 1){
                ///LUTAR
                //calcular o dano recebido e o dano infligido
                int dmg = jogador.atacar() - inimigos.defender();
                int dmgRecebido = inimigos.atacar() - jogador.defender();
                //verificar se o dano é negativo
                if(dmgRecebido < 0){
                    //adicionar dano ao inimigo se o jogador defender bem
                    dmg = dmgRecebido/2;
                    dmgRecebido = 0;
                }
                if(dmg < 0){
                    dmg = 0;
                    do{
                        dmg = jogador.atacar() - inimigos.defender();
                        dmgRecebido = inimigos.atacar() - jogador.defender();
                        if(dmgRecebido < 0){
                            //adicionar dano ao inimigo se o jogador defender bem
                            dmg = dmgRecebido/2;
                            dmgRecebido = 0;
                        }
                    }while(dmg < 0);
                }
                jogador.hp -= dmgRecebido;
                inimigos.hp -= dmg;
                //mostrar a informação do round
                clearConsole();
                escreverCabecalho("BATALHA");
                System.out.println("Voce deu " + dmg + " de dano no "+ inimigos.nome + ".");
                separarEscrita(30);
                System.out.println("O "+ inimigos.nome + " Deu " + dmgRecebido + " de dano.");
                qlqrCoisaCont();
                //verificar se o jogador ainda está vivo
                if(jogador.hp <= 0){
                    morte();
                    break;
                }else if(inimigos.hp <= 0){
                    //falar pro jogador que ele venceu
                    clearConsole();
                    System.out.println("Voce derrotou o "+ inimigos.nome +"!");
                    //aumentar o xp
                    jogador.xp += inimigos.xp;
                    System.out.println("Voce ganhou "+ inimigos.xp + "XP!");
                    //adicionar drops aleatórios
                    boolean addGraca = (Math.random()* 5 + 1 <= 2.25);
                    int ouroRecebido = (int) (Math.random() * inimigos.xp);
                    if(addGraca){
                        jogador.gracaRest++;
                        System.out.println("Voce encontrou uma graca adicional!");
                    }
                    if(ouroRecebido > 0){
                        jogador.gold += ouroRecebido;
                        System.out.println("Voce recebeu "+ ouroRecebido + " de ouro do " + inimigos.nome + " morto!");
                    }
                    qlqrCoisaCont();
                    break;
                }
            }else if(input == 2){
                //cura
                clearConsole();
                if(jogador.poteCura > 0 && jogador.hp < jogador.maxHp - 30){
                    //Jogador usa a pote de cura
                    escreverCabecalho("Voce tem certeza em tomar a pocao de cura? ("+ jogador.poteCura + " pocoes restantes).");
                    System.out.println("(1) Sim!\n(2) Nao, talvez mais tarde...");
                    input = readInt("-> ", 2);
                    if(input == 1){
                        //jogador usa a pote para se curar
                        jogador.hp = jogador.hp + 30;
                        clearConsole();
                        escreverCabecalho("Voce tomou uma pocao de cura. Ela restaurou sua vida para "+ jogador.hp);
                    }
                }else{
                    //jogador não pode usar poção de cura
                    escreverCabecalho("Voce nao tem nenhuma pocao ou esta com a vida cheia.");
                    qlqrCoisaCont();
                }
            }else{
                //FUGIR
                clearConsole();
                //sem fuga a partir do ato 4
                if(act != 4){ 
                    //Chance de fuga de 10%                  
                    if(Math.random()*10 + 1 <= 1.5){
                        escreverCabecalho("Voce fugiu com os rabos entre as pernas, PARABENS!");
                        qlqrCoisaCont();
                        break;
                    }else{
                        escreverCabecalho("Nao adianta tentar fugir, eles nao deixaram.");
                        //calcular o dano que o jogador toma
                        int dmgRecebido = inimigos.atacar();
                        jogador.hp -= dmgRecebido;
                        System.out.println("Voce foi pego ao tentar fugir, e tomou "+ dmgRecebido + " dano!");
                        qlqrCoisaCont();
                        if(jogador.hp <= 0){
                            morte();
                        }
                    }
                }else{
                    escreverCabecalho("Voce nao pode fugir do seu destino!!!");
                    qlqrCoisaCont();
                }
            }
            
        }
    }

    public static void battle(Boss boss) {
        //loop da batalha
        while(true){
            clearConsole();
            escreverCabecalho(boss.nome + "\nHP: " + boss.hp + "/" + boss.maxHp);
            escreverCabecalho(jogador.nome + "\nHP: " + jogador.hp + "/" + jogador.maxHp);
            System.out.println("Escolha oque fazer:");
            separarEscrita(20);
            System.out.println("(1) Lutar\n(2) curar\n (3) Fugir");
            int input = readInt("-> ", 3);
            //if para as escolhas do usuário
            if(input == 1){
                ///LUTAR
                //calcular o dano recebido e o dano infligido
                if(boss.hp < boss.maxHp/2){
                    int dmg = jogador.atacar() - boss.defender();
                    int dmgRecebido = boss.ataqueEspecial() - jogador.defender();
                    //verificar se o dano é negativo
                    if(dmgRecebido < 0){
                        //adicionar dano ao inimigo se o jogador defender bem
                        dmg = dmgRecebido/2;
                        dmgRecebido = 0;
                    }
                    if(dmg < 0)
                        dmg = 0;
                    jogador.hp -= dmgRecebido;
                    boss.hp -= dmg;
                    //mostrar a informação do round
                    clearConsole();
                    escreverCabecalho("BATALHA");
                    System.out.println("Voce deu " + dmg + " de dano no "+ boss.nome + ".");
                    separarEscrita(30);
                    System.out.println("O "+ boss.nome + " Deu " + dmgRecebido + " de dano.");
                    qlqrCoisaCont();
                    //verificar se o jogador ainda está vivo
                    if(jogador.hp <= 0){
                        morte();
                        isRunning = false;
                        break;
                    }else if(boss.hp <= 0){
                        //falar pro jogador que ele venceu
                        clearConsole();
                        System.out.println("Voce derrotou o "+ boss.nome +"!");
                        //aumentar o xp
                        jogador.xp += boss.xp;
                        System.out.println("Voce ganhou "+ boss.xp + "XP!");
                    }
                }
                int dmg = jogador.atacar() - boss.defender();
                int dmgRecebido = boss.atacar() - jogador.defender();
                //verificar se o dano é negativo
                if(dmgRecebido < 0){
                    //adicionar dano ao inimigo se o jogador defender bem
                    dmg = dmgRecebido/2;
                    dmgRecebido = 0;
                }
                if(dmg < 0)
                    dmg = 0;
                jogador.hp -= dmgRecebido;
                boss.hp -= dmg;
                //mostrar a informação do round
                clearConsole();
                escreverCabecalho("BATALHA");
                System.out.println("Voce deu " + dmg + " de dano no "+ boss.nome + ".");
                separarEscrita(30);
                System.out.println("O "+ boss.nome + " Deu " + dmgRecebido + " de dano.");
                qlqrCoisaCont();
                //verificar se o jogador ainda está vivo
                if(jogador.hp <= 0){
                    morte();
                    break;
                }else if(boss.hp <= 0){
                    //falar pro jogador que ele venceu
                    clearConsole();
                    System.out.println("Voce derrotou o "+ boss.nome +"!");
                    //aumentar o xp
                    jogador.xp += boss.xp;
                    System.out.println("Voce ganhou "+ boss.xp + "XP!");
                    //adicionar drops aleatórios
                    boolean addGraca = (Math.random()* 5 + 1 <= 2.25);
                    int ouroRecebido = (int) (Math.random() * boss.xp);
                    if(addGraca){
                        jogador.gracaRest++;
                        System.out.println("Voce encontrou uma graca adicional!");
                    }
                    if(ouroRecebido > 0){
                        jogador.gold += ouroRecebido;
                        System.out.println("Voce recebeu "+ ouroRecebido + " de ouro do " + boss.nome + " morto!");
                    }
                    qlqrCoisaCont();
                    break;
                }
            }else if(input == 2){
                //cura
                clearConsole();
                if(jogador.poteCura > 0 && jogador.hp < jogador.maxHp - 30){
                    //Jogador usa a pote de cura
                    escreverCabecalho("Voce tem certeza em tomar a pocao de cura? ("+ jogador.poteCura + " pocoes restantes).");
                    System.out.println("(1) Sim!\n(2) Nao, talvez mais tarde...");
                    input = readInt("-> ", 2);
                    if(input == 1){
                        //jogador usa a pote para se curar
                        jogador.hp = jogador.hp + 30;
                        clearConsole();
                        escreverCabecalho("Voce tomou uma pocao de cura. Ela restaurou sua vida para "+ jogador.hp +".\n o Boss aproveitando que voce estava se curando, recuperou 30 de vida");
                        boss.hp += 30;
                        if(boss.hp > boss.maxHp){
                            boss.hp = boss.maxHp;
                        }

                    }
                }else{
                    //jogador não pode usar poção de cura
                    escreverCabecalho("Voce nao tem nenhuma pocao ou esta com a vida cheia.");
                    qlqrCoisaCont();
                }
            }else{
                //FUGIR
                clearConsole();
                //sem fuga a partir do ato 4
                    escreverCabecalho("Voce nao pode fugir do seu destino!!!");
                    int dmgRecebido = boss.atacar();
                    jogador.hp -= dmgRecebido;
                    System.out.println("Voce foi pego ao tentar fugir, e tomou "+ dmgRecebido + " dano!");
                    qlqrCoisaCont();
                    if(jogador.hp <= 0){
                        morte();
                    }
                }
            
            }
        }

    //metodo printMenu
    public static void printMenu(){
        clearConsole();
        escreverCabecalho(places[place]);
        System.out.println("escolha uma opcao:");
        separarEscrita(20);
        System.out.println("(1) Continuar Jornada");
        System.out.println("(2) STATUS do Personagem");
        System.out.println("(3) Sair do jogo");
    } 

    //metodo quando o jogador morrer
    public static void morte(){
        clearConsole();
        escreverCabecalho("YOU DIED...");
        System.out.println("Obrigado por jogar! Boa sorte na sua próxima jornada, espero que tenha se divertido! :)");
        qlqrCoisaCont();
        isRunning = false;
        System.exit(0);
    }

    //main gameLoop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if(input == 1){
                continuarJornada();
            }else if(input == 2){
                infoPersonagem();
            }else{
                isRunning = false;
            }

        }
    }

    //final boss
    public static void finalbattle(){
        battle(new Boss("Radagon, da Ordem Aurea", 500, 75));
    }
    public static void boss1(){
        battle(new Boss("Godrick, O Enxertado", 100, 10));

    }
    public static void boss2(){
        battle(new Boss("Radahn, O Flagelo Estelar", 250, 35));
    }
    public static void boss3(){
        battle(new Boss("Godfrey, O Primeiro Lorde Pristino", 375, 50));
    }
}


