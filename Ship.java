
import java.util.Random;

public class Ship extends Space {
    int health;
    int posx;
    int posy;
    String name;
    Random rand = new Random();

    Ship(int hp, String nameString) {
        health = hp;
        name = nameString;
        boolean valid = false;
        do {
            posx = rand.nextInt(10);
            posy = rand.nextInt(10);
            int direction = rand.nextInt(4);
            switch (direction)
            {
                case 0 -> {
                    if (posx - health >= 0) {
                        valid = checkPosLeft();
                    }
                    if (valid) {
                        for (int i = 0; i < health; i++) {
                            Game.map[posx - i][posy] = this;
                        }
                    }
                    break;
                }
                case 1 -> {
                    if (posy - health >= 0) {
                        valid = checkPosUp();
                    }
                    if (valid) {
                        for (int i = 0; i < health; i++) {
                            Game.map[posx][posy - i] = this;
                        }
                    }
                    break;
                }
                case 3 -> {
                    if (posx + health <= 9) {
                        valid = checkPosRight();
                    }
                    if (valid) {
                        for (int i = 0; i < health; i++) {
                            Game.map[posx + i][posy] = this;
                        }
                    }
                    break;
                }
                case 4 -> {
                    if (posy + health <= 9) {
                        valid = checkPosDown();
                    }
                    if (valid) {
                        for (int i = 0; i < health; i++) {
                            Game.map[posx][posy + i] = this;
                        }
                    }
                    break;
                }
            }
        } 
        while (!valid);
    }

    private boolean checkPosLeft() {
        for (int i = 0; i < health; i++) {
            if (Game.map[posx - i][posy] instanceof Ship) {
                return false;
            } 
        }
        return true;
    }

    private boolean checkPosRight() {
        for (int i = 0; i < health; i++) {
            if (Game.map[posx + i][posy] instanceof Ship) {
                return false;
            } 
        }
        return true;
    }

    private boolean checkPosUp() {
        for (int i = 0; i < health; i++) {
            if (Game.map[posx][posy - i] instanceof Ship) {
                return false;
            } 
        }
        return true;
    }

    private boolean checkPosDown() {
        for (int i = 0; i < health; i++) {
            if (Game.map[posx][posy + i] instanceof Ship) {
                return false;
            } 
        }
        return true;
    }

    @Override
    public void shoot(int x, int y) {
        health -= 1;
        System.out.println("Hit");
        Game.map[x][y] = new HitSpace();
        Game.displayMap[x][y] = 'H';
        Game.shots += 1;
        if (health == 0) {
            System.out.println(name + " Sunk");
            Game.shipsLeft -= 1;
        }
    }
}
