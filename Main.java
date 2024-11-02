public class Main {
    public static void main(String[] args)
    {
        Game game = new Game();
        game.gameLoop();
        System.out.println();
        System.out.println();
        System.out.println("Congratulations! You won in " + Game.shots + " shots");
    }
}
