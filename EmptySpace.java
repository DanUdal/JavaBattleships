public class EmptySpace extends Space {
    @Override
    public void shoot(int x, int y) {
        System.out.println("Miss");
        Game.map[x][y] = new HitSpace();
        Game.displayMap[x][y] = 'M';
        Game.shots += 1;
    }
}
