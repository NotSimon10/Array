
package array;

import java.util.Random;

public class Enemy2 {
    
    public static int min = 2;
    public static int max = 19;
    public static final Random rand = new Random();
    public static int enemyX2 = rand.nextInt(max - min + 1) + min;
    public static int enemyY2 = rand.nextInt(max - min + 1) + min;
    public static boolean e2 = true;

    public Enemy2(int a, int b) {
        this.enemyX2 = a;
        this.enemyY2 = b;
    }

    public static int getEnemyX2() {
        return enemyX2;
    }

    public static void setEnemyX2(int enemyX2) {
        Enemy2.enemyX2 = enemyX2;
    }

    public static int getEnemyY2() {
        return enemyY2;
    }

    public static void setEnemyY2(int enemyY2) {
        Enemy2.enemyY2 = enemyY2;
    }

    public static boolean isE2() {
        return e2;
    }

    public static void setE2(boolean e2) {
        Enemy2.e2 = e2;
    }
    
}
