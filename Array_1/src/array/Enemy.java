
package array;

import java.util.Random;

public class Enemy {
    
    public static int min = 2;
    public static int max = 19;
    public static final Random rand = new Random();
    public static int enemyX = rand.nextInt(max - min + 1) + min;
    public static int enemyY = rand.nextInt(max - min + 1) + min;
    public static boolean e1 = true;

    public Enemy(int a, int b) {
       this.enemyX = a;
       this.enemyY = b;
    }

    public static int getEnemyX() {
        return enemyX;
    }

    public static void setEnemyX(int enemyX) {
        Enemy.enemyX = enemyX;
    }

    public static int getEnemyY() {
        return enemyY;
    }

    public static void setEnemyY(int enemyY) {
        Enemy.enemyY = enemyY;
    }

    public static boolean isE1() {
        return e1;
    }

    public static void setE1(boolean e1) {
        Enemy.e1 = e1;
    }
    
}
