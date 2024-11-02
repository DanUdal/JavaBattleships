public class EmptySpace extends Space {
    @Override
    public void shoot(int x, int y) {
        System.out.println("Miss");
        Main.map[x][y] = new HitSpace();
        Main.displayMap[x][y] = 'M';
    }
}
