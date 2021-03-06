package array;

import static array.Enemy.*;
import static array.Treasure.*;
import static array.Traps.*;
import java.util.Random;
import java.util.Scanner;

public class Array {

    public static String choose;
    public static String start;
    public static String buy;
    public static int lose;
    public static int shopcount = -1;
    public static boolean djump = false;
    public static boolean noenemy = false;
    public static boolean nebuy = false;
    public static boolean djbuy = false;
    public static int num = -2;
    public static boolean scorebool = false;
    
    //color related
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    //Skins Related
    public static String skins;
    public static int skincount;
    public static int equip;
    public static boolean SM = false;
    public static boolean SU = false;
    public static boolean HE = false;
    public static boolean MZ = false;
    public static boolean SQ = false;
    public static boolean HR = false;
    public static boolean CS = false;  
    public static boolean SD = false;  
    public static boolean OHM = false;  
    //Inventory Related
    public static final Random rand = new Random();
    public static int min = 2;
    public static int max = 19;
    public static int mincoin = 75;
    public static int maxcoin = 200;
    public static int coinvalue = rand.nextInt(maxcoin - mincoin + 1) + mincoin;
    public static int cointotal;
    public static int coinX = rand.nextInt(max - min + 1) + min;
    public static int coinY = rand.nextInt(max - min + 1) + min;

    public static Player player;
    public static Enemy enemy;
    public static Enemy2 enemy2;
    public static Traps traps;
    public static Treasure treasure;

    public static void main(String[] args) throws InterruptedException {
        story();
    }

    public static void story() throws InterruptedException {
        
        player = new Player(9, 9);
        enemy2 = new Enemy2(enemy2.enemyX2, enemy2.enemyY2);
        enemy = new Enemy(enemy.enemyX, enemy.enemyY);
        traps = new Traps(traps.trapX, traps.trapY);
        treasure = new Treasure(treasure.treasureX, treasure.treasureY);
        game();
    }

    public static void game() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("To buy powerups, collect coins in game! Your coin total is currently: " + cointotal + ".");
        System.out.println("Type \"shop\" to buy a powerup, \"skins\" to buy a new player model or \"play\" to start the game!");
        start = input.nextLine();
        if (start.contains("sh")) {
            shop();
        }
        else if (start.contains("sk")) {
            skin();
        }
        else if(start.contains("p")) {
            X();
            Y();
            enemy();
            map();
            Movement();
        } else {
            System.out.println("Input not parsed.");
            game();
        }
    }
    public static void map() throws InterruptedException {
        char[][] map = new char[20][20];
        if(skincount == 0) {
            map[player.InputY - 1][player.InputX - 1] = '@';
        }
        else if(skincount == 1) {
            map[player.InputY - 1][player.InputX - 1] = '♿';
        }
        else if(skincount == 2) {
            map[player.InputY - 1][player.InputX - 1] = '☭';
        }
        else if(skincount == 3) {
            map[player.InputY - 1][player.InputX - 1] = 'ღ';
        }
        else if(skincount == 4) {
            map[player.InputY - 1][player.InputX - 1] = '₪';
        }
        else if(skincount == 5) {
            map[player.InputY - 1][player.InputX - 1] = '▧';
        }
        else if(skincount == 6) {
            map[player.InputY - 1][player.InputX - 1] = '❥';
        }
        else if(skincount == 7) {
            map[player.InputY - 1][player.InputX - 1] = '♛';
        }
        else if(skincount == 8) {
            map[player.InputY - 1][player.InputX - 1] = '☪';
        }
        else if(skincount == 9) {
            map[player.InputY - 1][player.InputX - 1] = 'ʊ';
        }
        map[traps.trapY - 1][traps.trapX - 1] = '*';
        map[traps.trapYone - 1][traps.trapXone - 1] = '*';
        map[traps.trapYtwo - 1][traps.trapXtwo - 1] = '*';
        map[traps.trapYthree - 1][traps.trapXthree - 1] = '*';
        map[traps.trapYfour - 1][traps.trapXfour - 1] = '*';
        map[traps.trapYfive - 1][traps.trapXfive - 1] = '*';
        map[traps.trapYsix - 1][traps.trapXsix - 1] = '*';
        map[traps.trapYseven - 1][traps.trapXseven - 1] = '*';
        map[traps.trapYeight - 1][traps.trapXeight - 1] = '*';
        map[traps.trapYnine - 1][traps.trapXnine - 1] = '*';
        map[treasure.treasureY - 1][treasure.treasureX - 1] = 'T';
        map[treasure.treasureY2 - 1][treasure.treasureX2 - 1] = 'T';
        map[treasure.treasureY3 - 1][treasure.treasureX3 - 1] = 'T';
        map[enemy.enemyY - 1][enemy.enemyX - 2] = 'E';
        map[enemy2.enemyY2 - 1][enemy2.enemyX2 - 2] = 'E';
        map[coinY - 1][coinX - 1] = '◎';
        for (int i = 0; i <= map[0].length - 1; i++) {
            for (int j = 0; j <= map[1].length - 1; j++) {
                if (j < map[1].length - 1) {
                    if (i == 0) {
                        System.out.print("▬▬▬");
                    } else if (i == 19) {

                        System.out.print("▬▬▬");
                    } else if (j == 0) {
                        System.out.print("▐");
                    } else if (j == 19) {
                        System.out.print("▐");
                    } else if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != 'E' && map[i][j] != 'T' && map[i][j] != '◎' && map[i][j] != '♿' 
                            && map[i][j] != '☭' && map[i][j] != 'ღ' && map[i][j] != '₪' && map[i][j] != '▧' && map[i][j] != '❥' && map[i][j] != '♛'
                            && map[i][j] != '☪' && map[i][j] != 'ʊ') { //map[i][j] != 'x'
                        System.out.print(WHITE + " • ");
                    } else {
                        System.out.print (CYAN + " " + map[i][j] + CYAN + " ");
                    }
                } else if (i == 0) {
                    System.out.println("");
                } else if (i == 19) {
                    System.out.println("");
                } else if (j == 0) {
                    System.out.println("▐");
                } else if (j == 19) {
                    System.out.println("▐");
                } else if (map[i][j] != '@' && map[i][j] != '*' && map[i][j] != 'E' && map[i][j] != 'T' && map[i][j] != '◎' && map[i][j] != '♿' 
                        && map[i][j] != '☭' && map[i][j] != 'ღ' && map[i][j] != '₪' && map[i][j] != '₪' && map[i][j] != '❥' && map[i][j] != '♛'
                        && map[i][j] != '☪' && map[i][j] != 'ʊ') { //map[i][j] != 'x'
                    System.out.println(" • ");
                } else {
                    System.out.println(" " + map[i][j] + " ");
                }
            }
        }

        Movement();
    }

    public static void X() {
        Scanner x = new Scanner(System.in);
        System.out.println("Type a number 1-20 for the x value.");
        player.InputX = x.nextInt();
        if (player.InputX < 1 || player.InputX > 20) {
            System.out.println("Please choose another number.");
            X();
        }

    }

    public static void Y() {
        Scanner y = new Scanner(System.in);
        System.out.println("Type a number 1-20 for the y value.");
        player.InputY = y.nextInt();
        if (player.InputY < 1 || player.InputY > 20) {
            System.out.println("Please choose another number.");
            Y();
        }
    }

    static void Movement() throws InterruptedException {
        Scanner Move = new Scanner(System.in);
        System.out.println("\nCoin count: " + cointotal + ".\n");
        System.out.println("Do you want to go North[N], South[S], East[E], West[W]\nNortheast[NE], Southeast[SE], Northwest[NW], or Southwest[SW]?");
        player.move = Move.nextLine().toLowerCase();
        if (player.move.contains("n") && player.move.contains("e")) {
            player.InputY--;
            player.InputX++;
            enemy();
        } else if (player.move.contains("n") && player.move.contains("e")) {
            player.InputY--;
            player.InputX++;
            enemy();
        } else if (player.move.contains("s") && player.move.contains("e")) {
            player.InputY++;
            player.InputX++;
            enemy();
        } else if (player.move.contains("n") && player.move.contains("w")) {
            player.InputY--;
            player.InputX--;
            enemy();
        } else if (player.move.contains("s") && player.move.contains("w")) {
            player.InputY++;
            player.InputX--;
            enemy();
        } else if (player.move.contains("s") && player.move.contains("e")) {
            player.InputY++;
            player.InputX++;
            enemy();
        } else if (player.move.contains("n")) {
            if (player.InputY > 1 && player.InputY < 3) {
                player.InputY = 21;
            }
            if (enemy.enemyY > 1 && enemy.enemyY < 3) {
                enemy.enemyY = 20;
            }
            if (enemy2.enemyY2 > 1 && enemy2.enemyY2 < 3) {
                enemy2.enemyY2 = 20;
            }

            if (djump == true && !player.move.contains("1")) {
                player.InputY--;
            }
            player.InputY--;
            enemy();
        } else if (player.move.contains("s")) {
            if (player.InputY > 19 && player.InputY < 21) {
                player.InputY = 0;
            }
            if (enemy.enemyY > 18 && enemy.enemyY < 20) {
                enemy.enemyY = 2;
            }
            if (enemy2.enemyY2 > 18 && enemy2.enemyY2 < 20) {
                enemy2.enemyY2 = 2;
            }
            if (djump == true && !player.move.contains("1")) {
                player.InputY++;
            }

            player.InputY++;
            enemy();
        } else if (player.move.contains("e")) {
            if (player.InputX > 19 && player.InputX < 21) {
                player.InputX = 0;
            }
            if (enemy.enemyX > 18 && enemy.enemyX < 20) {
                enemy.enemyX = 2;
            }
            if (enemy2.enemyX2 > 18 && enemy2.enemyX2 < 20) {
                enemy2.enemyX2 = 2;
            }
            if (djump == true && !player.move.contains("1")) {
                player.InputX++;
            }
            player.InputX++;
            enemy();
        } else if (player.move.contains("w")) {
            if (player.InputX > 0 && player.InputX < 2) {
                player.InputX = 20;
            }
            if (enemy.enemyX > 1 && enemy.enemyX < 3) {
                enemy.enemyX = 19;
            }
            if (enemy2.enemyX2 > 1 && enemy2.enemyX2 < 3) {
                enemy2.enemyX2 = 19;
            }
            if (djump == true && !player.move.contains("1")) {
                player.InputX--;
            }
            player.InputX--;
            enemy();

        } else {
            System.out.println("Input not parsed.");
            Movement();
        }
    }

    public static void enemy() throws InterruptedException {
        System.out.println("Your location is: " + (player.InputX) + ", " + (player.InputY) + ".");
        //System.out.println("The first enemy's location is: " + (enemy.enemyX) + ", " + (enemy.enemyY) + " and second's is: " + (enemy2.enemyX2) + ", " + (enemy2.enemyY2) + ".");

        if (player.score == 3) {
            scorebool = true;
        }

        if (noenemy == true) {
            enemyX = 2;
            enemyY = 2;
            enemy2.enemyX2 = 2;
            enemy2.enemyY2 = 2;
            enemy2.e2 = false;
            e1 = false;
        }

        if (scorebool == true && noenemy == false) {
            enemyX = rand.nextInt(max - min + 1) + min;
            enemyY = rand.nextInt(max - min + 1) + min;
            enemy2.enemyX2 = rand.nextInt(max - min + 1) + min;
            enemy2.enemyY2 = rand.nextInt(max - min + 1) + min;
            e1 = true;
            enemy2.e2 = true;
        }
        if (scorebool == true) {
            treasureX = rand.nextInt(max - min + 1) + min;
            treasureY = rand.nextInt(max - min + 1) + min;
            treasureX2 = rand.nextInt(max - min + 1) + min;
            treasureY2 = rand.nextInt(max - min + 1) + min;
            treasureX3 = rand.nextInt(max - min + 1) + min;
            treasureY3 = rand.nextInt(max - min + 1) + min;
        }
        if (scorebool == true) {
            trapY = rand.nextInt(max - min + 1) + min;
            trapX = rand.nextInt(max - min + 1) + min;
            trapYone = rand.nextInt(max - min + 1) + min;
            trapXone = rand.nextInt(max - min + 1) + min;
            trapYtwo = rand.nextInt(max - min + 1) + min;
            trapXtwo = rand.nextInt(max - min + 1) + min;
            trapYthree = rand.nextInt(max - min + 1) + min;
            trapXthree = rand.nextInt(max - min + 1) + min;
            trapYfour = rand.nextInt(max - min + 1) + min;
            trapXfour = rand.nextInt(max - min + 1) + min;
            trapYfive = rand.nextInt(max - min + 1) + min;
            trapXfive = rand.nextInt(max - min + 1) + min;
            trapYsix = rand.nextInt(max - min + 1) + min;
            trapXsix = rand.nextInt(max - min + 1) + min;
            trapYseven = rand.nextInt(max - min + 1) + min;
            trapXseven = rand.nextInt(max - min + 1) + min;
            trapYeight = rand.nextInt(max - min + 1) + min;
            trapXeight = rand.nextInt(max - min + 1) + min;
            trapYnine = rand.nextInt(max - min + 1) + min;
            trapXnine = rand.nextInt(max - min + 1) + min;
        }
        if (scorebool == true) {
            coinX = rand.nextInt(max - min + 1) + min;
            coinY = rand.nextInt(max - min + 1) + min;
            coinvalue = rand.nextInt(maxcoin - mincoin + 1) + mincoin;
            scorebool = false;
        }

        if (player.health == 5) {
            player.totalhealth = player.health5;
        }
        if (player.health == 4) {
            player.totalhealth = player.health4;
        }
        if (player.health == 3) {
            player.totalhealth = player.health3;
        }
        if (player.health == 2) {
            player.totalhealth = player.health2;
        }
        if (player.health == 1) {
            player.totalhealth = player.health1;
        }
        if (player.health == 0) {
            lost();
            lose = 0;

        }
        System.out.println("Your health is currently: " + player.totalhealth + ".");

        System.out.println("Your Score is: " + player.score);
        if (player.InputX == treasure.treasureX2 && player.InputY == treasure.treasureY2) {
            treasure.treasureX2 = 1;
            treasure.treasureY2 = 1;
            player.score++;
            if (player.score == 3) {
                System.out.println("");
                scorebool = true;
                System.out.println("db    db  .d88b.  db    db    db   d8b   db d888888b d8b   db \n"
                        + "`8b  d8' .8P  Y8. 88    88    88   I8I   88   `88'   888o  88 \n"
                        + " `8bd8'  88    88 88    88    88   I8I   88    88    88V8o 88 \n"
                        + "   88    88    88 88    88    Y8   I8I   88    88    88 V8o88 \n"
                        + "   88    `8b  d8' 88b  d88    `8b d8'8b d8'   .88.   88  V888 \n"
                        + "   YP     `Y88P'  ~Y8888P'     `8b8' `8d8'  Y888888P VP   V8P ");
                lose = 10;
                lost();
            }
        } else if (player.InputX == treasure.treasureX && player.InputY == treasure.treasureY) {
            treasure.treasureX = 1;
            treasure.treasureY = 1;
            player.score++;
            if (player.score == 3) {
                System.out.println("");
                System.out.println("db    db  .d88b.  db    db    db   d8b   db d888888b d8b   db \n"
                        + "`8b  d8' .8P  Y8. 88    88    88   I8I   88   `88'   888o  88 \n"
                        + " `8bd8'  88    88 88    88    88   I8I   88    88    88V8o 88 \n"
                        + "   88    88    88 88    88    Y8   I8I   88    88    88 V8o88 \n"
                        + "   88    `8b  d8' 88b  d88    `8b d8'8b d8'   .88.   88  V888 \n"
                        + "   YP     `Y88P'  ~Y8888P'     `8b8' `8d8'  Y888888P VP   V8P ");
                lose = 10;
                lost();
            }
        } else if (player.InputX == treasure.treasureX3 && player.InputY == treasure.treasureY3) {
            treasure.treasureX3 = 1;
            treasure.treasureY3 = 1;
            player.score++;
            if (player.score == 3) {
                System.out.println("");
                System.out.println("db    db  .d88b.  db    db    db   d8b   db d888888b d8b   db \n"
                        + "`8b  d8' .8P  Y8. 88    88    88   I8I   88   `88'   888o  88 \n"
                        + " `8bd8'  88    88 88    88    88   I8I   88    88    88V8o 88 \n"
                        + "   88    88    88 88    88    Y8   I8I   88    88    88 V8o88 \n"
                        + "   88    `8b  d8' 88b  d88    `8b d8'8b d8'   .88.   88  V888 \n"
                        + "   YP     `Y88P'  ~Y8888P'     `8b8' `8d8'  Y888888P VP   V8P ");
                lose = 10;
                lost();
            }
        }

        if (player.InputX == traps.trapX && player.InputY == traps.trapY) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapX = 1;
            traps.trapY = 1;
        } else if (player.InputX == traps.trapXone && player.InputY == traps.trapYone) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXone = 1;
            traps.trapYone = 1;
        } else if (player.InputX == traps.trapXtwo && player.InputY == traps.trapYtwo) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXtwo = 1;
            traps.trapYtwo = 1;
        } else if (player.InputX == traps.trapXthree && player.InputY == traps.trapYthree) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXthree = 1;
            traps.trapYthree = 1;
        } else if (player.InputX == traps.trapXfour && player.InputY == traps.trapYfour) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXfour = 1;
            traps.trapYfour = 1;
        } else if (player.InputX == traps.trapXfive && player.InputY == traps.trapYfive) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXfive = 1;
            traps.trapYfive = 1;
        } else if (player.InputX == traps.trapXsix && player.InputY == traps.trapYsix) {
            System.out.println("\nYou hit a trap! You lose a heart");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXsix = 1;
            traps.trapYsix = 1;
        } else if (player.InputX == traps.trapXseven && player.InputY == traps.trapYseven) {
            System.out.println("\nYou hit a trap! You lose a heart");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXseven = 1;
            traps.trapYseven = 1;
        } else if (player.InputX == traps.trapXeight && player.InputY == traps.trapYeight) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXeight = 1;
            traps.trapYeight = 1;
        } else if (player.InputX == traps.trapXnine && player.InputY == traps.trapYnine) {
            System.out.println("\nYou hit a trap! You lose a heart!");
            player.health--;

//            lose = 0;
//            lost();
            traps.trapXnine = 1;
            traps.trapYnine = 1;
        }

        if (player.InputX == enemy.enemyX && player.InputY == enemy.enemyY) {
            player.health--;

            enemy.enemyX = 2;
            enemy.enemyY = 2;
            enemy.e1 = false;
            System.out.println("\nYou got hit by an enemy!");
            //lose = 0;
            //lost();
        }
        if (player.InputX == enemy2.enemyX2 && player.InputY == enemy2.enemyY2) {
            player.health--;

            enemy2.enemyX2 = 2;
            enemy2.enemyY2 = 1;
            enemy2.e2 = false;
            System.out.println("\nYou got hit by an enemy!");
            //lose = 0;
            //lost();
        }

        if (player.InputX > enemy2.enemyX2 && enemy2.e2 == true) {
            enemy2.enemyX2++;
        }
        if (player.InputY > enemy2.enemyX2 && enemy2.e2 == true) {
            enemy2.enemyY2++;
        }
        if (player.InputX < enemy2.enemyX2 && enemy2.e2 == true) {
            enemy2.enemyX2--;
        }
        if (player.InputY < enemy2.enemyY2 && enemy2.e2 == true) {
            enemy2.enemyY2--;
        }

        if (player.InputX > enemy.enemyX && enemy.e1 == true) {
            enemy.enemyX++;
        }
        if (player.InputY > enemy.enemyX && enemy.e1 == true) {
            enemy.enemyY++;
        }
        if (player.InputX < enemy.enemyX && enemy.e1 == true) {
            enemy.enemyX--;
        }
        if (player.InputY < enemy.enemyY && enemy.e1 == true) {
            enemy.enemyY--;
        }

        if (player.InputX == coinX && player.InputY == coinY) {
            coinX = 1;
            coinY = 1;
            coins();
        }
        map();
    }

    public static void coins() throws InterruptedException {
        cointotal += coinvalue;
        System.out.println("\nYou gained " + coinvalue + " coins! Good Job!");
        map();
    }

    public static void shop() throws InterruptedException {
        shopcount = 1;
        Scanner buys = new Scanner(System.in);
        player.wincount = player.wincount -= player.win;
        if (num < 1) {
            System.out.println("\nWelcome to the shop! Feel free to buy anything you need!");
            System.out.println("[Items]:");
            System.out.print("[No Enemies]: 300 Coins");
            if(nebuy == true) {
                System.out.println(" [" + player.wincount + " games left!]");
                noenemy = true;
            if(player.win >= 2) {
                player.win = 0;
                nebuy = false;
                noenemy = false;
        }
            }
            if(nebuy == false) {
                System.out.println(" [2 Games Only!]");
                noenemy = false;
            }
            System.out.println("[Double Jump]: 500 Coins");
            System.out.println("[One Heart]: 200 coins");
        }
        System.out.println("Would you like to buy something?");
        buy = buys.nextLine().toLowerCase();
        if (buy.contains("y")) {
            System.out.println("\nWhat would you like to buy?");
            System.out.println("[Item Names]: ");
            System.out.print("No Enemies = NE");
            if(nebuy == false) {
                System.out.println("");
            }
            if(nebuy == true) {
                System.out.println(" [Purchased]");
            }
            System.out.print("Double Jump = DJ");
            if(djbuy == false) {
                System.out.println("");
            }
            if(djbuy == true) {
                System.out.println(" [Purchased]");
            }
            System.out.print("One Heart = HE");
            if(player.health < 5) {
                System.out.println("");
            }
            if(player.health == 5) {
                System.out.println(" [Max Health]");
            }
            buy = buys.nextLine().toUpperCase();
            if (buy.contains("HE")) {
                if (cointotal >= 200) {
                    if(player.health == 5) {
                        System.out.println("\nYou have maximum health!");
                        shop();
                    }
                   
                    System.out.println("You have been charged 200 coins! Enjoy!");
                    cointotal -= 200;
                    player.health += 1;
                    num = -1;
                    game();
                } else {
                    num = -1;
                    System.out.println("\nYou cannot purchase this item! Returning to game!\n");
                    game();
                }
            } else if (buy.contains("NE")) {
                if (cointotal >= 300) {
                    if(nebuy == true) {
                        System.out.println("\nAlready Purchased.");
                        shop();
                    }
                    nebuy = true;
                    System.out.println("You have been charged 300 coins! Enjoy!");
                    cointotal -= 300;
                    nebuy = true;
                    noenemy = true;
                    num = -1;
                    game();
                } else {
                    num = -1;
                    System.out.println("\nYou cannot purchase this item! Returning to game!\n");
                    game();
                }
            }
              else if (buy.contains("DJ")) {
                if (cointotal >= 500) {
                    if(djbuy == true) {
                        System.out.println("\nAlready Purchased.");
                        shop();
                    }
                    System.out.println("You have been charged 500 coins! Enjoy!");
                    djbuy = true;
                    cointotal -= 500;
                    djump = true;
                    num = -1;
                    game();
                } else {
                    num = -1;
                    System.out.println("You cannot purchase this item! Returning to game!");
                    game();
                }
            } else {
                System.out.println("Input not parsed.");
                num = 1;
                shop();
            }
        } else {
            game();
        }
    }
    public static void skin() throws InterruptedException {
        Scanner skin = new Scanner(System.in);
        System.out.println("\nWelcome to the player skin model shop! Here you can buy many different"
                         + "\nskins to change the players look to your satisfaction! Enjoy.");
        System.out.println("\nPress [Enter] to buy!");
        skin.nextLine();
        System.out.println("[Items]:");
        System.out.println("[50 Coins]: ♿");
        System.out.println("[50 Coins]: ☭");
        System.out.println("[50 Coins]: ღ");
        System.out.println("[100 Coins]: ₪");
        System.out.println("[100 Coins]: ▧");       
        System.out.println("[100 Coins]: ❥");       
        System.out.println("[200 Coins]: ♛");       
        System.out.println("[200 Coins]: ☪");       
        System.out.println("[200 Coins]: ʊ");
        System.out.println("\nWould you like to purchase a character??");
        choose = skin.nextLine().toUpperCase();
        if(choose.contains("Y")) {
      System.out.print("[ツ]: SM");
        if(SM == false) {
            System.out.println("");
        }
        if(SM == true && equip != 1) {
            System.out.println(" [Equip]");
        }
        if(SM == true && equip == 1) {
            System.out.println(" [Equipped]");
        }
      System.out.print("[☭]: SU");
        if(SU == false) {
            System.out.println("");
        }
        if(SU == true && equip != 2) {
            System.out.println(" [Equip]");
        }
        if(SU == true && equip == 2) {
            System.out.println(" [Equipped]");
        }
      System.out.print("[ღ]: HE");
        if(HE == false) {
            System.out.println("");
        }
        if(HE == true && equip != 3) {
            System.out.println(" [Equip]");
        }
        if(HE == true && equip == 3) {
            System.out.println(" [Equipped]");
        }
      System.out.print("[₪]: MZ");
        if(MZ == false) {
            System.out.println("");
        }
        if(MZ == true && equip != 4) {
            System.out.println(" [Equip]");
        }
        if(MZ == true && equip == 4) {
            System.out.println(" [Equipped]");
        }
      System.out.print("[▧]: SQ");
        if(SQ == false) {
            System.out.println("");
        }
        if(SQ == true && equip != 5) {
            System.out.println(" [Equip]");
        }
        if(SQ == true && equip == 5) {
            System.out.println(" [Equipped]");
        }
      System.out.print("[❥]: HR");
        if(HR == false) {
            System.out.println("");
        }
        if(HR == true && equip != 6) {
            System.out.println(" [Equip]");
        }
        if(HR == true && equip == 6) {
            System.out.println(" [Equipped]");
        }
      System.out.print("[あ]: CS");
        if(CS == false) {
            System.out.println("");
        }
        if(CS == true && equip != 7) {
            System.out.println(" [Equip]");
        }
        if(CS == true && equip == 7) {
            System.out.println(" [Equipped]");
        }
      System.out.print("[۞]: SD");
        if(SD == false) {
            System.out.println("");
        }
        if(SD == true && equip != 8) {
            System.out.println(" [Equip]");
        }
        if(SD == true && equip == 8) {
            System.out.println(" [Equipped]");
        }
      System.out.print("[ʊ]: OHM");
        if(OHM == false) {
            System.out.println("");
        }
        if(OHM == true && equip != 9) {
            System.out.println(" [Equip]");
        }
        if(OHM == true && equip == 9) {
            System.out.println(" [Equipped]");
        }
        }
        else if(choose.contains("N")) {
            story();
        }
        skins = skin.nextLine();
        int coin = 50 - cointotal;
        if(skins.contains("SM")) {
            if(cointotal >= 0 && equip != 1) {
                skincount = 1;
                equip = 1;
                cointotal -= 0;
                System.out.println("You have been charged 50 coins! Your balance is: " + cointotal + "!");
                SM = true;
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            }
        }
        else if(skins.contains("SU")) {
            if(cointotal >= 0 && equip != 2) {
                skincount = 2;
                equip = 2;
                cointotal -= 0;
                if(SU == false) {
                System.out.println("You have been charged 50 coins! Your balance is: " + cointotal + "!");
                }
                SU = true;
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            } 
        }
           else if(skins.contains("HE")) {
            if(cointotal >= 0 && equip != 3) {
                skincount = 3;
                equip = 3;
                HE = true;
                cointotal -= 0;
                System.out.println("You have been charged 50 coins! Your balance is: " + cointotal + "!");
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            }
            
        }
           else if(skins.contains("MZ")) {
            if(cointotal >= 0 && equip != 4) {
                skincount = 4;
                equip = 4;
                MZ = true;
                cointotal -= 0;
                System.out.println("You have been charged 100 coins! Your balance is: " + cointotal + "!");
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            }
            
        }
           else if(skins.contains("SQ")) {
            if(cointotal >= 0 && equip != 5) {
                skincount = 5;
                equip = 5;
                SQ = true;
                cointotal -= 0;
                System.out.println("You have been charged 100 coins! Your balance is: " + cointotal + "!");
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            }
            
        }
           else if(skins.contains("HR")) {
            if(cointotal >= 0 && equip != 6) {
                skincount = 6;
                equip = 6;
                HR = true;
                cointotal -= 0;
                System.out.println("You have been charged 100 coins! Your balance is: " + cointotal + "!");
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            }
            
        }
           else if(skins.contains("CS")) {
            if(cointotal >= 0 && equip != 7) {
                skincount = 7;
                equip = 7;
                CS = true;
                cointotal -= 0;
                System.out.println("You have been charged 200 coins! Your balance is: " + cointotal + "!");
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            }
            
        }
           else if(skins.contains("SD")) {
            if(cointotal >= 0 && equip != 8) {
                skincount = 8;
                equip = 8;
                SD = true;
                cointotal -= 0;
                System.out.println("You have been charged 200 coins! Your balance is: " + cointotal + "!");
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            }
            
        }
           else if(skins.contains("OHM")) {
            if(cointotal >= 0 && equip != 9) {
                skincount = 9;
                equip = 9;
                OHM = true;
                cointotal -= 0;
                System.out.println("You have been charged 200 coins! Your balance is: " + cointotal + "!");
            } else {
                System.out.println("You dont have enough currency for this item! You need " + coin + " more coins!\n");
                game();
            }
            
        }
        game();
    }

    public static void lost() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        player.score = 0;
        scorebool = true;
        player.win++;
        if(player.win >= 2) {
            player.win = 0;
            nebuy = false;
        }
        if (player.health == 0) {
            System.out.println("");
            cointotal -= cointotal;
            player.health = 5;
            nebuy = false;
            skincount = 0;
            System.out.println("db    db  .d88b.  db    db    db       .d88b.  .d8888. d88888b \n"
                    + "`8b  d8' .8P  Y8. 88    88    88      .8P  Y8. 88'  YP 88'     \n"
                    + " `8bd8'  88    88 88    88    88      88    88 `8bo.   88ooooo \n"
                    + "   88    88    88 88    88    88      88    88   `Y8b. 88~~~~~ \n"
                    + "   88    `8b  d8' 88b  d88    88booo. `8b  d8' db   8D 88.     \n"
                    + "   YP     `Y88P'  ~Y8888P'    Y88888P  `Y88P'  `8888Y' Y88888P");
            System.out.println("");
        }
        System.out.println("\nDo you want to play again?");
        choose = scan.nextLine().toLowerCase();
        if (choose.contains("no")) {
            System.exit(0);
        } else if (choose.contains("yes")) {
            System.out.println("\nLet's play again!\n");
            story();
        } else {
            lost();
        }
    }

}