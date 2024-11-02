import java.util.Scanner;

public class Game {
    static final int MapSize = 10;
    static Space[][] map = new Space[MapSize][MapSize];
    static char[][] displayMap = new char[MapSize][MapSize];
    static int shipsLeft = 5;
    Scanner inputScanner = new Scanner(System.in);
    static int shots = 0;

    Game() {
        Ship[] ships = { new Ship(5, "Carrier"),  new Ship(4, "Battleship"), new Ship(3, "Submarine"),
            new Ship(3, "Destroyer"), new Ship(2, "Patrol Boat") };
            for (int i = 0; i < MapSize; i++) {
                for (int j = 0; j < MapSize; j++) {
                    if (!(map[i][j] instanceof Ship)) {
                        map[i][j] = new EmptySpace();
                    }
                    displayMap[i][j] = 'O';
                }
            }
    }

    public void gameLoop() {
        boolean finished = false;
        while (!finished) {
            outputMap();
            int x;
            int y;
            y = getInput();
            x = getInput();
            map[x][y].shoot(x, y);
            if (shipsLeft == 0) {
                finished = true;
            }
        }
    }

    public void outputMap() {
        System.out.println("    0   1   2   3   4   5   6   7   8   9");
        int i = 0;
        for (char[] line : displayMap) {
            System.out.print(i);
            i++;
            for (char space : line) {
                System.out.print("   " + space);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public int getInput() {
        int input = 0;
        boolean valid;
        do {
            valid = true;
            try {
                input = inputScanner.nextInt();
                System.out.println();
                if (input > 9 || input < 0) {
                    valid = false;
                }
            }
            catch(Exception e) {
                System.out.println("Invalid input. try again");
                valid = false;
            }
        } while (!valid);
        return input;
    }
}
