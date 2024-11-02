
import java.util.Scanner;

public class Main {
    static Space[][] map = new Space[10][10];
    static char[][] displayMap = new char[10][10];
    static int shipsLeft = 5;
    
    public static void main(String[] args)
    {
        try (Scanner inputScanner = new Scanner(System.in)) {
            @SuppressWarnings("unused")
            Ship ship = new Ship(5);
            ship = new Ship(4);
            ship = new Ship(3);
            ship = new Ship(3);
            ship = new Ship(2);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (map[i][j] instanceof Ship) {
                        
                    }
                    else {
                        map[i][j] = new EmptySpace();
                    }
                    displayMap[i][j] = 'O';
                }
            }
            boolean finished = false;
            while (!finished) {
                outputMap();
                boolean valid = true;
                int x = 0;
                int y = 0;
                do {
                    try {
                        y = inputScanner.nextInt();
                        System.out.println();
                        if (x > 9 || x < 0) {
                            valid = false;
                        }
                    }
                    catch(Exception e) {
                        System.out.println("Invalid input. try again");
                        valid = false;
                    }
                } while (!valid);
                valid = true;
                do {
                    try {
                        x = inputScanner.nextInt();
                        System.out.println();
                        if (y > 9 || y < 0) {
                            valid = false;
                        }
                    }
                    catch(Exception e) {
                        System.out.println("Invalid input. try again");
                        valid = false;
                    }
                } while (!valid);
                map[x][y].shoot(x, y);
                if (shipsLeft == 0) {
                    finished = true;
                }
            }
        }
    }

    public static void outputMap() {
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
}
